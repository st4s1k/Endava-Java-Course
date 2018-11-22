import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClasspathScanner {
    public static void main(String[] args) {
        ClassLoader classLoader = ClasspathScanner.class.getClassLoader();
        URLClassLoader ucl = null;

        if (classLoader instanceof URLClassLoader)
            ucl = (URLClassLoader)classLoader;
        else
            throw new RuntimeException("classLoader is not an instanceof URLClassLoader");

        URL[] urLs = ucl.getURLs();

        for (int i = 0; i < urLs.length; i++) {
            System.out.println( i + ". " + urLs[i]);
        }

    }
}
