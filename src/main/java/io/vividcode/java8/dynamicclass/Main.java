package io.vividcode.java8.dynamicclass;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.tuple.Pair;

public class Main {

  public static void main(String[] args) throws IOException {
    Pair<Path, String> result = DynamicCompilation.compile("(1 + 1) * 3 / 5.0");
    ClasspathUpdater.addPath(result.getLeft());
    System.out.println(Invoker.invoke(result.getRight()));
  }
}
