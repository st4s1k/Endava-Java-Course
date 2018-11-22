import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

public class ClasspathScanner extends ClassLoader {

    public List<Object> getObjects(String path) {

        List<Object> objects = new ArrayList<>();

        try {

            Enumeration<URL> resources = ClassLoader.getSystemResources(path);

            while (resources.hasMoreElements()) {

                final URL resource = resources.nextElement();

                File file = new File(resource.getPath());

                System.out.println(file);

                if(!file.exists())
                    throw new FileNotFoundException();

                System.out.println("File is a directory: " + file.isDirectory());
                System.out.println("File is a file: " + file.isFile());

                objects.addAll(scan(file));
            }

        } catch (IOException |
                IllegalAccessException |
                InvocationTargetException |
                InstantiationException e) {

            e.printStackTrace();

        }

        return objects;
    }

    public List<Object> scan(File root) throws IOException,
                                                IllegalAccessException,
                                                InvocationTargetException,
                                                InstantiationException {

        List<Object> objecs = new ArrayList<>();

        if (root.isDirectory()) {
            final File[] rootFiles = root.listFiles();
            if (rootFiles == null) return objecs;
            for (File rootFile: rootFiles) {
                scan(rootFile);
            }
        }
        else if (root.getName().endsWith(".class")) {
//            final byte[] classBytes = Files.readAllBytes(root.toPath());
//            final Class<?> loadedClass = defineClass(
//                    root.getName().substring(0, root.getName().length() - ".class".length()),
//                    classBytes,
//                    0,
//                    classBytes.length
//            );
//            final Constructor<?>[] constructors = loadedClass.getConstructors();
//            if (constructors != null &&
//                    constructors.length > 0 &&
//                    loadedClass.isAnnotationPresent(Managed.class) &&
//                    loadedClass.isAnnotationPresent(DefaultValue.class)
//            ) {
//                Object o = constructors[0].newInstance();
//
//                Field[] fields = o.getClass().getDeclaredFields();
//
//                for (Field field : fields) {
//                    field.setAccessible(true);
//                    if (field.isAnnotationPresent(DefaultValue.class))
//                    {
//                        Object value = field.getAnnotation(DefaultValue.class).value();
//                        field.set(o, value);
//                        System.out.println(field + "\t" + value);
//                    }
//                }
//
//                objecs.add(o);
//
//            }
        }
        return objecs;
    }
}

