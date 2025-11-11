//package org.example.joblisting.Config;
//
//import lombok.RequiredArgsConstructor;
//import org.example.joblisting.Config.JWT.JwtFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@RequiredArgsConstructor
//public class Config {
//
//    private final JwtFilter jwtFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//
//                // ✅ public routes
//                .requestMatchers("/api/v1/auth/**").permitAll()
//                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//
//                // ✅ HR only can add/update/delete
//                .requestMatchers("/api/v1/job-listing/add-job").hasAuthority("HR")
//                .requestMatchers("/api/v1/job-listing/update-job").hasAuthority("HR")
//                .requestMatchers("/api/v1/job-listing/delete-job").hasAuthority("HR")
//
//                // ✅ Anyone can view jobs
//                .requestMatchers("/api/v1/job-listing/jobs").permitAll()
//
//                .anyRequest().authenticated();
//
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}
