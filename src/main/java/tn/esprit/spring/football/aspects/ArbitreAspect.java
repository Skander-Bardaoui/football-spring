package tn.esprit.spring.football.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ArbitreAspect {


    @AfterThrowing(
            pointcut = "execution(* tn.esprit.spring.football.services.*.affecterArbitreARencontre(..))",
            throwing = "exception"
    )
    public void logAfterThrowingException(Exception exception) {
        log.warn("Il faut affecter un arbitre de même niveau que la rencontre");
    }
}
