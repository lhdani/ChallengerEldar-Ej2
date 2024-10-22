package com.eldar.challenger.service;

import com.eldar.challenger.domain.Usuario;
import com.eldar.challenger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario altaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
