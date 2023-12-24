package design.zykus.zykus.clothing;

import design.zykus.zykus.clothing.utils.Role;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		WebAppUser adminAccount = userRepository.findByRole(Role.ADMIN);
		if (adminAccount == null) {
			WebAppUser user = new WebAppUser();
			user.setUserName("admin");
			LocalDate dob = LocalDate.of(2023, 10, 1);
			user.setDateOfBirth(dob);
			user.setAge(26);
			user.setGender("Male");
			user.setAddress("Lucknow");
			user.setPinCode(1234);
			user.setState("UP");
			user.setCountry("India");
			user.setEmail("admin@gmail.com");
			user.setFirstName("yash");
			user.setMiddleName("raj");
			user.setLastName("srivastav");
			user.setRole(Role.ADMIN);
			user.setUserPassword(new BCryptPasswordEncoder().encode("admin"));

			userRepository.save(user);
		}
	}
}
