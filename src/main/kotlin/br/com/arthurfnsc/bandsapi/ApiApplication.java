package br.com.arthurfnsc.bandsapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    //@Value("${spring.security.oauth2.client.registration.google.client-id}")
    //private String clientId;

    //@Value("${spring.security.oauth2.client.registration.google.client-secret}")
    //private String clientSecret;

    public static void main(String[] args) {
        //System.out.println("=> " + new ApiApplication().clientId);
        //System.out.println("==> " + new ApiApplication().clientSecret);

        SpringApplication.run(ApiApplication.class, args);
    }
}
