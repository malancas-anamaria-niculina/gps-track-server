package project.gpstrack.server.position;

import lombok.Data;

import java.util.Date;

@Data
public class PositionDTO {
    private String terminalId;

    private String user;

    private double latitude;
    private double longitude;

    private Date creationDate;
}
