package project.gpstrack.server.position;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping("/create")
    public Position create(@RequestBody PositionDTO position){
        return positionService.create(position);
    }

    @GetMapping("/getTerminalIds")
    public List<Position> search(@RequestParam("username") String username){
        return positionService.search(username);
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
    public Position updatePositon(@RequestParam("id") String id, @RequestBody PositionDTO position){
        return positionService.updatePosition(id, position);
    }

    @GetMapping("/getLocations")
    public List<Position> getLocations(@RequestParam("terminalId") String terminalId,
                                       @RequestParam("startDate") String startDate,
                                       @RequestParam("finalDate") String finalDate) throws ParseException {
        return positionService.getLocations(terminalId, startDate, finalDate);
    }

    @DeleteMapping("/deleteAll")
    public void deleteLocations(){
        positionService.deleteAllPosition();
    }

}
