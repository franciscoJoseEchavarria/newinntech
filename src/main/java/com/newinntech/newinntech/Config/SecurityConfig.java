package com.newinntech.newinntech.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Configuración del SecurityFilterChain para definir las reglas de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // Permite acceso a endpoints públicos o específicos, aquí se requiere autenticación para todas las solicitudes
                        .anyRequest().authenticated()
                         )
                // Se habilita autenticación básica
                .httpBasic(Customizer.withDefaults())
                // Deshabilitar CSRF si es una API REST (opcional, según tus necesidades)
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    // Definición de un servicio de usuarios en memoria (útil para pruebas)
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder() // Solo para pruebas; en producción usar un encoder adecuado
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
