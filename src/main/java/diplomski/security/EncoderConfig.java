package diplomski.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncoderConfig {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	    Map<String, PasswordEncoder> encoders = new HashMap<>();
	    encoders.put("bcrypt", new BCryptPasswordEncoder());
	    
	    DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
	      "bcrypt", encoders);
	    passworEncoder.setDefaultPasswordEncoderForMatches(encoders.get("bcrypt"));
	    return passworEncoder;
	}

}
