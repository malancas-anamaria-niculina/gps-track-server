package project.gpstrack.server.position;


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

    @GetMapping("/getPosition")
    public Optional<Position> search(@RequestParam("id") String id){
        return positionService.search(id);
    }

    @DeleteMapping("/delete")
    public void deletePosition(@RequestParam("id") String id){
        positionService.deletePosition(id);
    }

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PutMapping("/updatePosition")
    public Position updatePositon(@RequestParam("id") String id, @RequestBody Position position){
        return positionService.updatePosition(id, position);
    }

}
