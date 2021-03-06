package net.momoka.unirest;

import java.io.InputStream;
import java.io.IOException;

import com.qianka.util.http.HttpService;
import com.qianka.util.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger LOGGER =
    LoggerFactory.getLogger(Main.class);


  public static void main(String[] args) throws Exception {


    String url = "http://guest:guest@n1413.ops.gaoshou.me:15672/api/" +
      "queues/%2F/notify.chenlei.test.urgent/bindings";

    Response resp = HttpService.get(url);

    LOGGER.debug(resp.getBodyAsString());

  }

}
