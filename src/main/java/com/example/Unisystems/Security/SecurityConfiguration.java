package com.example.Unisystems.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").authorities("AccessCompanies")
                .and()
                .withUser("employee").password(passwordEncoder().encode("employee")).roles("EMPLOYEE");
                /*.and()
                .withUser("companyManager").password(passwordEncoder().encode("companyManager")).roles("COMPANY_MANAGER")
                .and()
                .withUser("businessUnitManager").password(passwordEncoder().encode("businessUnitManager")).roles("BUSINESS_UNIT_MANAGER")
                .and()
                .withUser("unitManager").password(passwordEncoder().encode("unitManager")).roles("UNIT_MANAGER")
                .and()
                .withUser("departmentManager").password(passwordEncoder().encode("departmentManager")).roles("DEPARTMENT_MANAGER")*/

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // oloi oi xrhstes paizoune by default,
                                                                   // xrysimopoieis .antMatchers().authenticated(),
                                                                   // gia periorismo afairw to .authenticated()
                                                                   // kai krataw paradeigma  "/companies" mallon
                                                                   // gia POST DELETE ktl
        http
                .authorizeRequests()
                //.antMatchers("/**").authenticated()
               .antMatchers("/companies").hasAuthority("AccessCompanies")
                //.antMatchers("/**").hasAnyRole("EMPLOYEE","ADMIN")
                .and()
                //.httpBasic()
                .formLogin()
                .and()
                .logout();//.logoutRequestMatcher(new AntPathRequestMatcher("/signOut")).logoutSuccessUrl("/");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
