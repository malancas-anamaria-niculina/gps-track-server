package project.gpstrack.server.position;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PositionRepository extends MongoRepository<Position, String> {
    @Query("{\"terminalId\": ?0, \"creationDate\": { $gt: ?1, $lt: ?2 }}")
    List<Position> getPosition(String terminalId, Date startDate, Date finalDate);

    @Query("{\"user\": ?0}")
    List<Position> searchPositionByUser(String username);
}
