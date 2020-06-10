package cn.com.nets;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import io.nats.client.Options;
import io.nats.client.Subscription;
import java.nio.charset.StandardCharsets;

public class Client3 {
  public static void main(String... args) throws Exception {
    // Options options = new Options.Builder().server("nats://172.26.34.80:4222").maxReconnect(-1);
    Options options =
        new Options.Builder().server("nats://172.26.34.80:4222").maxReconnects(-1).build();
    Connection nc = Nats.connect(options);
    Dispatcher d = nc.createDispatcher((msg) -> {});
    Subscription s =
        d.subscribe(
            "subject",
            "click",
            (msg) -> {
              String response = new String(msg.getData(), StandardCharsets.UTF_8);
              System.out.println("Message received (up to 100 times): " + response);
            });

    d.unsubscribe(s, 100);
    /// nc.close();
  }
}
