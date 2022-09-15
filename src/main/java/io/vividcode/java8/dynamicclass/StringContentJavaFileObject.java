package io.vividcode.java8.dynamicclass;

import java.net.URI;
import javax.tools.SimpleJavaFileObject;

public class StringContentJavaFileObject extends SimpleJavaFileObject {

  private final String content;

  public StringContentJavaFileObject(String name, String content) {
    super(URI.create("string:///" + name + Kind.SOURCE.extension),
        Kind.SOURCE);
    this.content = content;
  }

  @Override
  public CharSequence getCharContent(boolean ignoreEncodingErrors) {
    return content;
  }
}
