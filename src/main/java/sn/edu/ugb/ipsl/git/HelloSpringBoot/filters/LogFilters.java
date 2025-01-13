package sn.edu.ugb.ipsl.git.HelloSpringBoot.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;

@Component
public class LogFilters extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("#####LOGFILTER"+request.getRequestURI());
        //laisser passer la requete
        String ip = request.getRemoteHost();
        String nom = request.getRemoteAddr();
        System.out.println("ip:"+ip+" nom:"+nom);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println("headerName:"+headerName+" headerValue:"+headerValue);

        }
        System.out.println("en-tete: "+request.getHeaderNames());
        filterChain.doFilter(request, response);
    }
}
