package project.gpstrack.server.position;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Data
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Autowired private MongoTemplate mongoTemplate;

    public Position create(PositionDTO position){
        Position position1 = new Position();
        position1.setLatitude(position.getLatitude());
        position1.setLongitude(position.getLongitude());
        position1.setTerminalId(position.getTerminalId());

        position.setCreationDate(new Date(System.currentTimeMillis()));
        return positionRepository.save(position1);
    }

    public void deletePosition(String id){
        positionRepository.deleteById(id);
    }

    public List<Position> getAllPositions(){return positionRepository.findAll();}

    public Optional<Position> search(String id){return positionRepository.findById(id);}

    public List<Position> getLocations(String terminalId, String startDate, String finalDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = new Date(sdf.parse(startDate).getTime());
        Date fd = new Date(sdf.parse(finalDate).getTime());
        Criteria c = Criteria.where("terminalId").is(terminalId)
                .andOperator(Criteria.where("creationDate").gte(sd),
                            Criteria.where("creationDate").lt(fd));
        Query querry = new Query(c);

        return mongoTemplate.find(querry, Position.class);
    }

    public Position updatePosition(String id, PositionDTO position){
        if (positionRepository.findById(id).isPresent()){
            Position position1 = positionRepository.findById(id).get();
            position1.setTerminalId(position.getTerminalId());
            position1.setLatitude(position.getLatitude());
            position1.setLongitude(position.getLongitude());
            position.setCreationDate(new Date(System.currentTimeMillis()));
            return positionRepository.save(position1);
        }
        return null;
    }

}
