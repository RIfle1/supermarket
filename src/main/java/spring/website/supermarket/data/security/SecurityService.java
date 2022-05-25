package spring.website.supermarket.data.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public void logout(){
        UI.getCurrent().getPage().setLocation("/");
        SecurityContextLogoutHandler securityContextLogoutHandler =
                new SecurityContextLogoutHandler();
        securityContextLogoutHandler
                .logout(VaadinServletRequest
                        .getCurrent()
                        .getHttpServletRequest(), null, null);

    }
}
