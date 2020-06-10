package cn.com.nets;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Options;
import io.nats.client.Subscription;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Client2 {
  public static void main(String... args) throws Exception {
    // Options options = new Options.Builder().server("nats://172.26.34.80:4222").maxReconnect(-1);
    Options options =
        new Options.Builder().server("nats://172.26.34.80:4222").maxReconnects(-1).build();
    Connection nc = Nats.connect(options);
    String subject = "ad";
    String queue = "click";
    int i = 0;
    Subscription sub = nc.subscribe("subject", queue);
    while (true) {

      Message msg = sub.nextMessage(Duration.ofMillis(500));
      if (msg != null) {
        String response = new String(msg.getData(), StandardCharsets.UTF_8);
        System.out.println(response);
      }
    }
    /// nc.close();
  }
}
