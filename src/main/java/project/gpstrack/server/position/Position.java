package project.gpstrack.server.position;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Data
@Document(collection = "positions")
public class Position {
    @Id
    private String id;

    private String terminalId;
    private String latitude;
    private String longitude;

    private Date creationDate;
}
