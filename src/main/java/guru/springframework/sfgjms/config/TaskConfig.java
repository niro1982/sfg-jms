package guru.springframework.sfgjms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * setting up a Bean taskExecutor
 * @EnableAsync ability to run asyncteast
 * @EnableScheduling tells spring to inspect classes for scheduled tasks
 */
@EnableScheduling
@EnableAsync
@Configuration
public class TaskConfig {

    //the configuration annotation tells spring to look for bean annotated with @Bean
    //annotation and to inject an instance of them to the spring context
    @Bean
    TaskExecutor taskExecutor(){
        return new SimpleAsyncTaskExecutor();
    }
}
