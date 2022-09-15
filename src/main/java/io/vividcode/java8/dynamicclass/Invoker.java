package io.vividcode.java8.dynamicclass;

import java.lang.reflect.Method;

public class Invoker {

  public static Object invoke(String className) {
    try {
      Method method = Class.forName(className).getDeclaredMethod("calculate");
      return method.invoke(null);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
