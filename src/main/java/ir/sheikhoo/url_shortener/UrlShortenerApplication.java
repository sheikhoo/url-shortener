package ir.sheikhoo.url_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UrlShortenerApplication {

    public static void main(String[] args) {
        System.out.println("HI: ");
        System.out.println(new BCryptPasswordEncoder().encode("123"));
        SpringApplication.run(UrlShortenerApplication.class, args);
    }

}
