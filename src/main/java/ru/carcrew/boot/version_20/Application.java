package ru.carcrew.boot.version_20;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.carcrew.boot.version_20.models.Article;
import ru.carcrew.boot.version_20.models.User;


@SpringBootApplication
public class Application {
	Configuration configuration = new Configuration().addAnnotatedClass(User.class)
			.addAnnotatedClass(Article.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
