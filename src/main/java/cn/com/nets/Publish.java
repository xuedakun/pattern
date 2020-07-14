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
     String msg= "{\"partnerId\":\"1536249520\",\"userLicense\":\"川A57884\",\"parkId\":\"010202004214913\"," +
             "\"adId\":\"adclick78fe4961bd00489cb51110f733d1f052\",\"sign\":" +
             "\"MEUCIDV/Ppje0WQfL2J7BvXCvkJO2scFK4Etv9VKLdnAHc8KAiEA9VIguw52fAZK9uHXdFg4uks3v59c3Uzqk32ckaUDbL4=\",\"userMobile\":\"1881471091\",\"openId\":\"43237107\"}";
      nc.publish("ad", "click", (msg).getBytes(StandardCharsets.UTF_8));

    /// nc.close();
  }
}
