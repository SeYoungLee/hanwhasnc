package examples.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import examples.guestbook.config.DBConfig;

@Configuration
@ComponentScan(basePackages = { "examples.guestbook.service", 
								"examples.guestbook.dao"})
@Import({ DBConfig.class })
public class ApplicationConfiguration {

}
