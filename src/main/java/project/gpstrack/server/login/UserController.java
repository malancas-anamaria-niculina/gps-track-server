package project.gpstrack.server.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import project.gpstrack.server.position.Position;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          PasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/record")
    public void signUp(@RequestBody ApplicationUser user) {

        ApplicationUser qUser = applicationUserRepository.findByUsername(user.getUsername());
        if (qUser == null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            applicationUserRepository.save(user);
        }
    }
}