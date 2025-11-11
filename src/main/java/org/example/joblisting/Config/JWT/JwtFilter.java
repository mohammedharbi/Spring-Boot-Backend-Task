//package org.example.joblisting.Config.JWT;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class JwtFilter extends GenericFilter {
//
//    private final JwtUtil jwtUtil;
//
//    Claims claims = jwtUtil.getClaims(token);
//    String username = claims.getSubject();
//    String role = claims.get("role", String.class);
//
//    UsernamePasswordAuthenticationToken auth =
//            new UsernamePasswordAuthenticationToken(
//                    username,
//                    null,
//                    List.of(new SimpleGrantedAuthority(role))
//            );
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        String auth = req.getHeader("Authorization");
//
//
//
//        if (auth != null && auth.startsWith("Bearer ")) {
//            String token = auth.substring(7);
//
//            if (jwtUtil.validate(token)) {
//                Claims claims = jwtUtil.getClaims(token);
//                String username = claims.getSubject();
//                String role = claims.get("role", String.class);
//
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(
//                                username, null,
//                                List.of(new SimpleGrantedAuthority(role))
//                        );
//
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//
//}
