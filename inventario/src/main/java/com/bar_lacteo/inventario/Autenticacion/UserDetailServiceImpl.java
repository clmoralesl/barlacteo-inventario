package com.bar_lacteo.inventario.Autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario.Usuario.Usuario;
import com.bar_lacteo.inventario.Usuario.UsuarioRepositorio;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(usuario.getNombreUsuario())
                .password(usuario.getContrasenia())
                .roles(usuario.getRol().name())
                .build();
    }
    
}
