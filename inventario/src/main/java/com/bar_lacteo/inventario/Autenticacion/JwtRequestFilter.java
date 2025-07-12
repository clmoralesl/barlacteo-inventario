package com.bar_lacteo.inventario.Autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtRequestFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header recibido: " + authHeader);

        String username = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            System.out.println("Token JWT extraído: " + jwt);

            try {
                username = jwtUtil.extractUsername(jwt);
                System.out.println("Usuario extraído del token: " + username);
            } catch (Exception e) {
                System.out.println("Error al extraer username del token: " + e.getMessage());
            }
        } else {
            System.out.println("Header Authorization no presente o no empieza con Bearer");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            boolean valid = jwtUtil.validateToken(jwt, username);
            System.out.println("¿Token válido?: " + valid);

            if (valid) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("Usuario autenticado: " + username);
            } else {
                System.out.println("Token inválido, no se autentica usuario");
            }
        } else {
            System.out.println("Usuario es null o ya autenticado en contexto");
        }

        chain.doFilter(request, response);
    }
}
