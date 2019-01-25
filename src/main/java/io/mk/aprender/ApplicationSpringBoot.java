package io.mk.aprender;

import io.mk.aprender.configuration.database.InitialDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ApplicationSpringBoot extends SpringBootServletInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationSpringBoot.class);

    @Autowired
    private InitialDatabaseService initialDatabaseService;

    @Bean
    CommandLineRunner preLoadMongo() throws Exception {
        return args -> {
            initialDatabaseService.initial();
        };
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationSpringBoot.class, args);

        try {
            Environment env = ctx.getEnvironment();

            LOG.info("\n\n *** \n\n" + "\tAplicacao {} iniciada com sucesso!\n" + "\tDisponivel nos enderecos:\n"
                            + "\tLocal: http://localhost:{}\n" + "\tExterno: http://{}:{}\n" + "\tSwagger Url: http://{}:{}\n"
                            + "\tLocal Swagger Url: http://localhost:{}\n" + "\n *** \n\n",
                    env.getProperty("spring.application.name"),
                    env.getProperty("server.port") + env.getProperty("server.servlet.contextPath"),
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port") + env.getProperty("server.servlet.contextPath"),
                    InetAddress.getLocalHost().getHostAddress(),
                    env.getProperty("server.port") + env.getProperty("server.servlet.contextPath") + "/swagger-ui.html",
                    env.getProperty("server.port") + env.getProperty("server.servlet.contextPath")
                            + "/swagger-ui.html");

        } catch (UnknownHostException e) {
            LOG.error("Falha ao executar aplicacao: {}", e);
            ctx.close();
        }

    }
}
