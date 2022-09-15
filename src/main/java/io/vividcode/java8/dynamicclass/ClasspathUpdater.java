package io.vividcode.java8.dynamicclass;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class ClasspathUpdater {

  public static void addPath(Path path) {
    URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    try {
      Method method = URLClassLoader.class.getDeclaredMethod("addURL",
          URL.class);
      method.setAccessible(true);
      method.invoke(classLoader, path.toUri().toURL());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
