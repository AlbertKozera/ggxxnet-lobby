package ggxnet.reload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories
@EnableWebSocketMessageBroker
public class GGXXLobbyApplication {

  public static void main(String[] args) {
    SpringApplication.run(GGXXLobbyApplication.class, args);
  }
}
