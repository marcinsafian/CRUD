package com.crud.tasks.service.mail;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class SchedulerMailCreatorService implements MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    private TaskFacade facade;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Value("${front-end.url}")
    private String frontEndUrl;

    public String createMail(String message) {

        List<TaskDto> tasks = facade.getTasks();

        Context context = new Context();

        context.setVariable("message", message);
        context.setVariable("show_button", true);
        context.setVariable("is_friend", false);
        context.setVariable("task_url", frontEndUrl);
        context.setVariable("button", "Visit website");
        context.setVariable("send_button", "Send to trello");
        context.setVariable("admin_config", adminConfig);

        context.setVariable("company_config", companyConfig);


        context.setVariable("show_tasks", tasks.size() != 0);
        context.setVariable("tasks_in_DB", tasks);

        return templateEngine.process("mail/scheduler-mail", context);
    }
}
