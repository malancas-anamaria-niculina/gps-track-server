package project.gpstrack.server.position;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping("/create")
    public Position create(@RequestBody Position position){
        return positionService.create(position);
    }

    @GetMapping("/search/{id}")
    public Optional<Position> search(@RequestParam("id") String id){
        return positionService.search(id);
    }

    @GetMapping("/")
    public List<Position> findAll() {
        return positionService.findAll();
    }
}
