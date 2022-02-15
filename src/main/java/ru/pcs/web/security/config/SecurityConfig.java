package ru.pcs.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService customerDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/customers").authenticated()
                .antMatchers("/customers/**").authenticated()              //.hasAuthority("USER") //вообще нужно ADMIN, но для простоты чтобы на все страницы перехоидило
                .antMatchers("/signUp") .authenticated()
                .antMatchers("/catalog_of_books") .authenticated()
                .antMatchers("/catalog_of_books/**") .authenticated()
                .antMatchers("/pay/") .authenticated()          // .permitAll()
                .antMatchers("/files/upload/**").authenticated()
                .antMatchers(HttpMethod.GET, "/files/**").authenticated()               //.permitAll()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/customers")
                .permitAll();
    }
}
