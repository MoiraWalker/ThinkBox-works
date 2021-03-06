package nl.walker.novi.thinkbox;
import  nl.walker.novi.thinkbox.payload.request.SignupRequest;
import  nl.walker.novi.thinkbox.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import nl.walker.novi.thinkbox.domain.Project;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseFiller implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> rollen = new HashSet<>();
        rollen.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.nl");
        admin.setPassword("123456");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest user = new SignupRequest();
        user.setUsername("user");
        user.setEmail("user@user.nl");
        user.setPassword("123456");
        rollen.remove("admin");
        rollen.add("user");
        user.setRole(rollen);
        authorizationService.registerUser(user);

    }
}
