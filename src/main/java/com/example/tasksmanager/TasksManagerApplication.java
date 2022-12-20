package com.example.tasksmanager;

import com.example.tasksmanager.model.User;
import com.example.tasksmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TasksManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			userRepository.save(new User("User", encoder.encode("UserPassword")));
			userRepository.save(new User("Admin", encoder.encode("AdminPassword")));
		};
	}
}
