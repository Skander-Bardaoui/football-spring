package tn.esprit.spring.football;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.football.entities.Rencontre;
import tn.esprit.spring.football.repositories.RencontreRepositories;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class RencontreScheduler {

    RencontreRepositories rencontreRepo;

    @Scheduled(cron = "0 0 8 * * *")
    public void rencontreDeDateSys() {
        LocalDate today = LocalDate.now();

        List<Rencontre> rencontres = rencontreRepo.findByDateMatchBetween(
                today.atStartOfDay(),
                today.atTime(23, 59, 59)
        );

        log.info("Rencontres du jour: {}", rencontres);
    }
}