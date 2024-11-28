package org.xproce.tprevision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpRevisionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpRevisionApplication.class, args);
        System.out.println("Application started on http://localhost:8090/graphiql");
    }
}
