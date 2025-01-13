package sn.edu.ugb.ipsl.git.HelloSpringBoot.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class IpslAuthFilters extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getHeader("IpslLogin") != null) {
            String ipslLogin = request.getHeader("IpslLogin");
            List<SimpleGrantedAuthority> authorities = List.of(
                    new SimpleGrantedAuthority("ROLE_ETUDIANT")
                    //new SimpleGrantedAuthority("ROLE_ADMIN")
            );
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(
                            new UsernamePasswordAuthenticationToken(ipslLogin, null, authorities)
                    );

            //List<String> prenoms = List.of("Abdou","Fatou","Pathe");
        }
        filterChain.doFilter(request, response);
    }
}
