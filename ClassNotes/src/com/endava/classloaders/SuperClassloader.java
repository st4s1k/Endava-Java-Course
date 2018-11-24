package com.endava.classloaders;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Enumeration;

public class SuperClassloader extends ClassLoader {


    void init() {
        try {
            Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources("");
            while (resources.hasMoreElements()) {
                final  URL url = resources.nextElement();
                File file = new File(url.getPath());
                System.out.println(file);
                traverse(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void traverse(File root) throws IOException {
        if (root.isDirectory()) {
            final File[] rootFiles = root.listFiles();
            if (rootFiles != null) {
                for (File rootFile: rootFiles) {
                    traverse(rootFile);
                }
            } else throw new NoSuchFileException(root.getAbsolutePath());
        } else {
            if (root.getName().endsWith(".class")) {
                final byte[] classBytes = Files.readAllBytes(root.toPath());
                final Class<?> loadedClass = defineClass(null, classBytes, 0, classBytes.length);
                final Constructor<?>[] constructors = loadedClass.getDeclaredConstructors();
//                if (constructors.length == 0)

            }
        }
    }
}
