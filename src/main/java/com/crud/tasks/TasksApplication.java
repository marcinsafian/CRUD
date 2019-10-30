package com.crud.tasks;

import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasksApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
		TrelloClient n = new TrelloClient();
		n.getTrelloBoards();
		System.out.println(n);
	}
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
	    return application.sources(TasksApplication.class);
    }
    // wylaczone dla heroku
	 */

}
