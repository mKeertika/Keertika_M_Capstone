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
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests(requests -> requests
//                        .mvcMatchers("/login").permitAll()
//                        .mvcMatchers("/signup").permitAll()
//                        .mvcMatchers("/about").permitAll()
//                        .mvcMatchers("/contact").permitAll()
//                        .mvcMatchers("/").permitAll()
////                        .mvcMatchers("/savePost").hasRole("USER")
////                        .mvcMatchers("/updatePost").hasRole("USER")
//                        .mvcMatchers("/persons/user-detail-page").hasRole("SUPERADMIN")
//                        .anyRequest().authenticated())
//                .formLogin(login -> login
//                        .loginPage("/login")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/index"));
//
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
//                .withUser("user")
//                .password(passwordEncoder.encode("user"))
//                .roles("USER")
//                .and().withUser("superadmin")
//                .password(passwordEncoder.encode("superadmin"))
//                .roles("USER", "SUPERADMIN");
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/static/**")
//                .antMatchers("/**/*.css")
//                .antMatchers("/**/*.png")
//                .antMatchers("/**/*.ico")
//                .antMatchers("/**/*.jpg")
//                .antMatchers("/**/*.jpeg");
//    }
//}
