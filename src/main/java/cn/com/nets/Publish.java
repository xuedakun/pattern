package cn.com.nets;

import io.nats.client.Connection;
import io.nats.client.Nats;
import io.nats.client.Options;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Publish {
  public static void main(String... args) throws Exception {
    //     Options options = new
    // Options.Builder().server("nats://172.26.34.80:4222").maxReconnect(-1);
    Publish.pulish1();
  }

  public static void pulish1() throws IOException, InterruptedException {
    Options options =
        new Options.Builder().server("nats://172.26.34.80:4222").maxReconnects(-1).build();
    Connection nc = Nats.connect(options);
    String subject = "ad";
    String queue = "click";
    int i = 0;
    while (true) {
      nc.publish("subject", "click", ("hello world" + i + "").getBytes(StandardCharsets.UTF_8));
      Thread.sleep(1000);
      i++;
    }
    /// nc.close();
  }
}
