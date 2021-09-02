package pl.sdaproject.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdaproject.quiz.database.entities.PlayerEntity;
import pl.sdaproject.quiz.database.repositories.PlayerRepository;
import pl.sdaproject.quiz.services.QuizDataService;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Executing startup actions...");
       playerRepository.save(new PlayerEntity("John"));
       playerRepository.save(new PlayerEntity("Harry"));
       playerRepository.save(new PlayerEntity("George"));


        log.info("List of players from database: ");
        List<PlayerEntity> playersFromDb = playerRepository.findAll();

        for(PlayerEntity playerFromDb: playersFromDb) {
            log.info("Player from Db: " + playerFromDb);
        }

        quizDataService.getQuizCategories();
    }
}
