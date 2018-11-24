package com.endava;

import com.endava.SomeOtherPackage.SomeClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

public class ClasspathScanner extends ClassLoader {

    private static void fileInfo(String prefix, File file) {

        StringBuilder info = new StringBuilder();

        info.append("\n\t").append(prefix).append('\t');

        if (file.isDirectory()) info.append("d").append('\t');

        if (file.isFile())      info.append("f").append('\t');

        if (file.exists())      info.append("e").append('\t');

        info.append(file.getName()).append('\t').append(file).append('\n');

        System.out.print(info);
    }

    public List<Object> getObjects(String path) {

        List<Object> objects = new ArrayList<>();

        try {

            Enumeration<URL> resources = ClassLoader.getSystemResources(path);

            while (resources.hasMoreElements()) {

                final URL resource = resources.nextElement();

                File file = new File(resource.getPath());

                fileInfo("getObjects():", file);

                objects.addAll(scan(file));
            }

        } catch (IOException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {

            e.printStackTrace();

        }

        return objects;
    }

    public List<Object> scan(File root)
            throws
            IOException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        fileInfo("      scan():", root);

        List<Object> objecs = new ArrayList<>();

        if (root.isDirectory()) {
            final File[] rootFiles = root.listFiles();
            if (rootFiles == null) return objecs;
            for (File rootFile: rootFiles) {
                scan(rootFile);
            }
        }
        else if (root.getName().endsWith(".class")) {
            final byte[] classBytes = Files.readAllBytes(root.toPath());
            final Class<?> loadedClass = defineClass(
                    null,
                    classBytes,
                    0,
                    classBytes.length
            );
            final Constructor<?>[] constructors = loadedClass.getConstructors();
            if (
                    constructors != null &&
                    constructors.length > 0 &&
                    loadedClass.isAnnotationPresent(Managed.class)
            ) {
                Object o = constructors[0].newInstance();

                Boolean

                Field[] fields = o.getClass().getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(DefaultValue.class))
                    {
                        Object value = field.getAnnotation(DefaultValue.class).value();
                        field.set(o, value);
                        System.out.println(field + "\t" + value);
                    }
                }

                objecs.add(o);

            }
        }
        return objecs;
    }
}

