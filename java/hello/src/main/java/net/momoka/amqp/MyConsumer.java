package net.momoka.amqp;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.Recoverable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConsumer extends DefaultConsumer {

  private static final Logger LOGGER =
    LoggerFactory.getLogger(MyConsumer.class);

  public MyConsumer(Channel channel) {
    super(channel);
  }

  @Override
  public void handleDelivery(
    String consumerTag,
    Envelope envelope,
    AMQP.BasicProperties properties,
    byte[] body) throws IOException {

    long dTag = envelope.getDeliveryTag();

    LOGGER.debug("consumerTag: {}", consumerTag);
    LOGGER.debug("body: {}", new String(body));
    LOGGER.debug("routing_key: {}", envelope.getRoutingKey());
    LOGGER.debug("deliveryTag: {}", dTag);

    // getChannel().basicAck(dTag, false);
  }

}
