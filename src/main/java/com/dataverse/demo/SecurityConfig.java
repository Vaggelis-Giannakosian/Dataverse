package com.dataverse.demo;

import com.dataverse.demo.security.AccountLoginAuthenticationProvider;
import com.dataverse.demo.security.DeniedPageHandler;
import com.dataverse.demo.security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountLoginAuthenticationProvider accountLoginAuthenticationProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public DeniedPageHandler accessDeniedHandler(){
        return new DeniedPageHandler();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login")
                .successHandler(loginSuccessHandler)
                .permitAll()
                .and()



                .logout()
                .logoutUrl("/logOut")
                .logoutSuccessUrl("/login")
                .permitAll()


                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logOut").permitAll()
                .antMatchers("/home/**").hasAuthority("USER")
                .and()

                .authenticationProvider(accountLoginAuthenticationProvider)

                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
        ;
    }

}
