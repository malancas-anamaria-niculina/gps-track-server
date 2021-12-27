package project.gpstrack.server.login;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "login")
public class ApplicationUser {
    @Id
    private String id;
    private String username;
    private String password;
}
