package io.vividcode.java8.dynamicclass;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.UUID;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import org.apache.commons.lang3.tuple.Pair;

public class DynamicCompilation {

  private static final String CLASS_NAME = "Calculator";

  public static Pair<Path, String> compile(String expr) throws IOException {
    String packageName = "z" + UUID.randomUUID().toString().replace("-", "");
    Path outputPath = Files.createTempDirectory("expr");
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,
        null, null);
    compiler.getTask(null, fileManager, null, ImmutableList.of(
                "-d", outputPath.toAbsolutePath().toString()
            ), null,
            Collections.singletonList(
                new StringContentJavaFileObject(CLASS_NAME,
                    getJavaSource(packageName, expr))))
        .call();
    return Pair.of(outputPath, packageName + "." + CLASS_NAME);
  }

  private static String getJavaSource(String packageName, String expr) {
    return "package " + packageName + "; "
        + "public class " + CLASS_NAME
        + " { public static Object calculate() {  "
        + "return " + expr + "; }" +
        "}";
  }
}
