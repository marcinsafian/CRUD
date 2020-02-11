package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.mail.SchedulerMailCreatorService;
import com.crud.tasks.service.mail.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private SchedulerMailCreatorService mailCreatorService;

    private String createMessage() {
        long size = taskRepository.count();
        return "Currently in database you got : " + size + ((size == 1) ? " task" : " tasks");
    }

    @Scheduled(cron = "0 0 10 * * *")
    private void sendInformationEmail() {
        emailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, createMessage(), mailCreatorService));
    }
}
