package com.example.testpjt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // application에 추가하면 편하지만 분리하는 이유(https://hellorennon.tistory.com/9)
public class JpaAuditingConfiguration {

}
