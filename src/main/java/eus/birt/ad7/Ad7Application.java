package eus.birt.ad7;

import eus.birt.ad7.domain.Ascend;
import eus.birt.ad7.domain.Climber;
import eus.birt.ad7.domain.Crag;
import eus.birt.ad7.domain.Grade;
import eus.birt.ad7.domain.Route;
import eus.birt.ad7.repository.ClimberRepository;
import eus.birt.ad7.repository.CragRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class Ad7Application implements CommandLineRunner {

    private final CragRepository cragRepository;
    private final ClimberRepository climberRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ad7Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Route route = Route.builder().name("Richelier").baseGrade(Grade.SEVEN_B_PLUS).build();
        Crag crag = Crag.builder().name("Valdegovía").routes(Set.of(route)).build();
        Ascend ascend = Ascend.builder().grade(Grade.SEVEN_B).route(route).build();
        Climber climber = Climber.builder().name("Leticia").lastName("Toja").ascends(Set.of(ascend)).build();

        cragRepository.save(crag);
        climberRepository.save(climber);
    }
}
