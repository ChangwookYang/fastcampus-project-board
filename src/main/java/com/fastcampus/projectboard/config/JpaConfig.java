package com.fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    static {
        System.setProperty("spring.datasource.username", "root");
        System.setProperty("spring.datasource.password", "1234");
    }


    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("changwook"); // TODO 스프링 시큐리티 도입 시 수정예정
    }
}
