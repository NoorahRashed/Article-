package com.example.demo;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.RoleRebo;
import com.example.demo.models.reposetory.UserRebo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;

import java.util.ArrayList;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRebo roleRebo, UserRebo userRebo ) {
		return args -> {
			Role userrole = new Role(1,"USER");
			Role adminrole = new Role(1,"ADMIN");
			roleRebo.save(userrole);
			roleRebo.save(adminrole);
			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
			User user= new User(1,
					"Norah",
					"Norah@gmail.com",
					"0587438296",
					bCryptPasswordEncoder.encode("norah123"),
					new ArrayList<>(),
					Arrays.asList(userrole,adminrole));
			User user1= new User(2,
					"Aljoharah",
					"Aljoharah@gmail.com",
					"0587438296",
					bCryptPasswordEncoder.encode("Aljoharah123"),
					new ArrayList<>(),
					Arrays.asList(userrole));
			User user2= new User(3,
					"Lama",
					"Lama@gmail.com",
					"0587438296",
					bCryptPasswordEncoder.encode("lama123"),
					new ArrayList<>(),
					Arrays.asList(adminrole));
			userRebo.save(user);
			userRebo.save(user1);
			userRebo.save(user2);
		};
	}

}
