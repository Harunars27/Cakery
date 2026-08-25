package com.vanelli.cakery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // REST API kullandığımız için CSRF'i kapatıyoruz
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        // Müşterilerin ürünleri görmesi ve sipariş oluşturması HERKESE AÇIK
                        .requestMatchers(HttpMethod.GET, "/api/products/**", "/api/categories/**", "/api/settings/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/orders/create").permitAll()

                        // Diğer tüm işlemler (Ekleme, Silme, Sipariş Okuma) GİZLİ ve ADMIN YETKİSİ İSTER
                        .requestMatchers("/api/**").authenticated()

                        // Statik dosyalarımız (HTML, CSS, JS resimler) herkese açık
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()); // HTTP Basic Authentication (Temel Kimlik Doğrulama) kullanıyoruz

        return http.build();
    }

    // Admin Şifresini Burada Belirliyoruz
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}vanelli2026") // {noop} -> Şifreyi şimdilik düz metin okuması için
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}