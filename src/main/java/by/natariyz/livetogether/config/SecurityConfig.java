package by.natariyz.livetogether.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static by.natariyz.livetogether.utils.Constants.ControllerMappingPaths.REGISTER;
import static by.natariyz.livetogether.utils.Constants.ControllerMappingPaths.SIGN_IN;
import static by.natariyz.livetogether.utils.Constants.ControllerMappingPaths.SIGN_IN_SUCCESS;
import static by.natariyz.livetogether.utils.Constants.Parameters.LOGIN;
import static by.natariyz.livetogether.utils.Constants.Parameters.PASSWORD;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorization -> authorization
                        .requestMatchers(HttpMethod.GET, REGISTER).permitAll()
                        .requestMatchers(HttpMethod.POST, REGISTER).permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage(SIGN_IN)
                        .usernameParameter(LOGIN)
                        .passwordParameter(PASSWORD)
                        .successForwardUrl(SIGN_IN_SUCCESS)
                        .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
