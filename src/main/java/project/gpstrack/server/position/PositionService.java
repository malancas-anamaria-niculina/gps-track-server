package project.gpstrack.server.position;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position create(Position position){
        position.setCreationDate(new Date(System.currentTimeMillis()));
        return positionRepository.save(position);
    }

    public void deletePosition(String id){
        positionRepository.deleteById(id);
    }

    public List<Position> getAllPositions(){return positionRepository.findAll();}

    public Optional<Position> search(String id){return positionRepository.findById(id);}

    public Position updatePosition(String id, Position position){
        position.setId(id);
        position.setCreationDate(new Date(System.currentTimeMillis()));
        return positionRepository.save(position);
    }

}
