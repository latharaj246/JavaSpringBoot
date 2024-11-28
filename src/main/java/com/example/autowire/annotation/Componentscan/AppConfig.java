package com.example.autowire.annotation.Componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.autowire.annotation.Componentscan  ")
public class AppConfig {
}
