package org.springframework.samples.manageCruz.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
	DataSource dataSource;

    AuthenticationManagerBuilder auth;

    PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(DataSource dataSource, AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        this.dataSource = dataSource;
        this.auth = auth;
        this.passwordEncoder = passwordEncoder;
        configureGlobal(auth, passwordEncoder);
    }

    
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username,password,true "
                + "from users "
                + "where username = ?")
            .authoritiesByUsernameQuery("select username,role "
                + "from users "
                + "where username = ?")
                .passwordEncoder(passwordEncoder);	
	}



}
