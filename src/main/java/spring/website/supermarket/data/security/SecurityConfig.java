package spring.website.supermarket.data.security;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import spring.website.supermarket.views.LoginComponents.LoginView;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        setLoginView(http, LoginView.class);
        http.authorizeRequests()
                .antMatchers("/supermarketedit").hasRole("ADMIN")
                .antMatchers("/supermarket").hasAnyRole("","ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
        super.configure(http);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build());
    }


}
