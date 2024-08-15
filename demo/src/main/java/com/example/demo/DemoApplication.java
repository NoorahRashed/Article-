package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = {"com.example.demo.models.reposetory"})
@SpringBootApplication
@Log4j2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(RoleRebo roleRebo, UserRebo userRebo ) {
//		return args -> {

//			Role userrole = new Role(1,"USER");
//			log.info(userrole.toString());
//			Role adminrole = new Role(2,"ADMIN");
//			Role role = new Role();
//			role.setId(3);
//			role.setRoleName("new");
//			log.info(adminrole.toString());
//			roleRebo.save(role);
//			roleRebo.save(userrole);
//			roleRebo.save(adminrole);

//			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//
//			User user= new User(1,
//					"Norah",
//					"Norah@gmail.com",
//					"0587438296",
//					bCryptPasswordEncoder.encode("norah123"),
//					new ArrayList<>(),
//					Arrays.asList(userrole,adminrole));
//
//			User user1= new User(2,
//					"Aljoharah",
//					"Aljoharah@gmail.com",
//					"0587438296",
//					bCryptPasswordEncoder.encode("Aljoharah123"),
//					new ArrayList<>(),
//					Arrays.asList(userrole));
//
//			User user2= new User(3,
//					"Lama",
//					"Lama@gmail.com",
//					"0587438296",
//					bCryptPasswordEncoder.encode("lama123"),
//					new ArrayList<>(),
//					Arrays.asList(adminrole));
//
//			userRebo.save(user);
//			userRebo.save(user1);
//			userRebo.save(user2);
//		};
//	}

}