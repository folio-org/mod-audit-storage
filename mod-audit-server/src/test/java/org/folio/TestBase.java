package org.folio;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import io.vertx.junit5.VertxExtension;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class TestBase {

  public static final String CHECK_IN_PAYLOAD_JSON = "payloads/check_in.json";
  public static final String CHECK_OUT_PAYLOAD_JSON = "payloads/check_out.json";
  public static final String REQUEST_CREATED_PAYLOAD_JSON = "payloads/request_created.json";

  public String getFile(String filename) {
    String value = "";
    try (InputStream inputStream = this.getClass()
      .getClassLoader()
      .getResourceAsStream(filename)) {
      if (inputStream != null) {
        value = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      }
    } catch (Exception e) {
      value = "";
    }
    return value;
  }
}
