package com.rocketcode.backend_library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Deshabilitar CSRF, ya que estamos usando sesiones
                .authorizeRequests()
                .antMatchers("/login", "/register", "/api/books/**").permitAll()  // Acceso libre a login y registro
                .anyRequest().authenticated()  // El resto de las rutas requieren autenticación
                .and()
                .formLogin()
                .loginPage("/login")  // Página de login personalizada
                .permitAll()
                .and()
                .logout()
                .permitAll();  // Permitir que el usuario cierre sesión
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configurar autenticación en memoria (puedes usar base de datos aquí)
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}