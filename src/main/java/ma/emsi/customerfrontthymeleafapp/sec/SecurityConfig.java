package ma.emsi.customerfrontthymeleafapp.sec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(ar->ar.requestMatchers("/","/auth","/customers","/products","/webjars/**","h2-console/**").permitAll())
                .oauth2Login(Customizer.withDefaults())
                .logout((logout)-> logout
                        .logoutSuccessUrl("/").permitAll()
                        .deleteCookies("JSESSIONID"))
                .build();
    }
}
