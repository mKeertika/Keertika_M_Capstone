//package org.perscholas.KeertikamSpringBootBlogAppCapstone.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
////        http.authorizeRequests(requests -> requests
////                        .mvcMatchers("/login").permitAll()
////                        .mvcMatchers("/").permitAll()
////                        .mvcMatchers("/deleteEmployee/**").hasRole("SUPERADMIN")
////                        .mvcMatchers("/showFormForUpdate/**").hasRole( "SUPERADMIN")
////                        .mvcMatchers("/showEmployeeForm/**").permitAll()
////                        .mvcMatchers("/saveEmployee/**").permitAll()
////                        .anyRequest().authenticated())
////                .formLogin(login -> login
////                        .loginPage("/login")
////                        .permitAll())
////                .logout(logout -> logout
////                        .logoutSuccessUrl("/login"));
////
////        http.authorizeRequests()
////                .mvcMatchers("/actuator/**").permitAll() // Allow access to Actuator endpoints
////                .anyRequest().authenticated() // Require authentication for other requests
////                .and()
////                .formLogin().permitAll(); // Enable form-based login
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        PasswordEncoder passwordEncoder
//                = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//
//               .withUser("superadmin")
//                .password(passwordEncoder.encode("superadmin"))
//                .roles("USER", "ADMIN", "SUPERADMIN");
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/static/**")
//                .antMatchers("/**/*.css");
//    }
//}
