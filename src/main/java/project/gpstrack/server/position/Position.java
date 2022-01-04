package project.gpstrack.server.position;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "positions")
public class Position {
    @Id
    private String id;

    private String user;

    private String terminalId;
    private double latitude;
    private double longitude;

    private Date creationDate;
}
