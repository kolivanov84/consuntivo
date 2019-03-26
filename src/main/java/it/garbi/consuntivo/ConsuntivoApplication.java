package it.garbi.consuntivo;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsuntivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsuntivoApplication.class, args);
	}

	
	@Bean
	public BasicTextEncryptor textEncryptor() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("mySecretEncriptionKeyBlaBla1234");
		return textEncryptor;
	}
}
