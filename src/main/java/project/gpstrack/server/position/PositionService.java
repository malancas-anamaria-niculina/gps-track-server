package project.gpstrack.server.position;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position create(Position position){
        return positionRepository.save(position);
    }

    public List<Position> findAll(){return positionRepository.findAll();}

    public Optional<Position> search(String id){return positionRepository.findById(Integer.valueOf(id));}

}
