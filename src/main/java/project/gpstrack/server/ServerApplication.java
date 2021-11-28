package project.gpstrack.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.gpstrack.server.position.Position;
import project.gpstrack.server.position.PositionRepository;
import project.gpstrack.server.position.PositionService;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.nio.channels.Pipe;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    public void run(String... args){
        Position position = new Position();
        position.setLatitude("0.450000");
        position.setLongitude("8.3440000");
        position.setTerminalId("12");
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        position.setCreationDate(new Date(stamp.getTime()));
        new PositionService().create(position);
    }

    @Bean
    public Docket apiTest() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("project.gpstrack.server"))
                .paths(PathSelectors.any())
                .build();
    }
}
