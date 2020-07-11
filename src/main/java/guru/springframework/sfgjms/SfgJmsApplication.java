package guru.springframework.sfgjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgJmsApplication {

	public static void main(String[] args) {

		//This server configuration for embedded activeMQ is actually not needed when having the 2 dependencies
		//in teh pom, spring will configure it for us
/*				<dependency>
			<groupId>org.apache.activemq</groupId>
			<artifactId>artemis-server</artifactId>
		</dependency>

		<dependency>
			<groupId>org.apache.activemq</groupId>
			<artifactId>artemis-jms-server</artifactId>
		</dependency>*/





/*		ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
			.setPersistenceEnabled(false)
			.setJournalDirectory("target/data/journal")
			.setSecurityEnabled(false)
			.addAcceptorConfiguration("invm", "vm://0"));

		server.start();*/

		SpringApplication.run(SfgJmsApplication.class, args);
	}

}
