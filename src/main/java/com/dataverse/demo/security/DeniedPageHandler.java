package com.dataverse.demo.security;

import com.dataverse.demo.domain.EnumUserType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAccessDeniedHandler")
public class DeniedPageHandler implements AccessDeniedHandler {


        private static final String USER_HOME_PAGE_URL = "/home";

        @Override
        public void handle(
                HttpServletRequest request,
                HttpServletResponse response,
                AccessDeniedException exc) throws IOException, ServletException {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();


            if(auth.getAuthorities()
                    .stream()
                    .anyMatch(a -> ((GrantedAuthority) a).getAuthority().equals(EnumUserType.USER.name()))){
                response.sendRedirect(request.getContextPath() + "/home");
            }else {
                response.sendRedirect(request.getContextPath() + "/");
            }

        }
    }

