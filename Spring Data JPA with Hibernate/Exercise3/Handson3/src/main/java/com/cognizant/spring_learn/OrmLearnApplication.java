package com.cognizant.spring_learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.spring_learn.model.Attempt;
import com.cognizant.spring_learn.model.AttemptOption;
import com.cognizant.spring_learn.model.AttemptQuestion;
import com.cognizant.spring_learn.model.Option;
import com.cognizant.spring_learn.service.AttemptService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        testGetAttempt();

    }

    private void testGetAttempt() {

        Attempt attempt = attemptService.getAttempt(1, 1);

        System.out.println("User : " + attempt.getUser().getName());
        System.out.println("Attempt Date : " + attempt.getAttemptedDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {

            System.out.println();
            System.out.println(aq.getQuestion().getText());

            for (Option option : aq.getQuestion().getOptionList()) {

                boolean selected = false;

                for (AttemptOption ao : aq.getAttemptOptions()) {

                    if (ao.getOption().getId() == option.getId()) {
                        selected = ao.isSelected();
                    }

                }

                System.out.println(option.getText()
                        + "\t"
                        + option.getScore()
                        + "\t"
                        + selected);
            }
        }
    }
}