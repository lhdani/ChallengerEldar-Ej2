package com.eldar.challenger.controller;


import com.eldar.challenger.domain.Usuario;
import com.eldar.challenger.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Tag(description = "Gestión de Usuarios", name = "Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/alta")
    @Operation(summary = "Alta de un nuevo usuario", description = "Crea un nuevo usuario con los datos proporcionados")
    public Usuario altaUsuario(@RequestBody Usuario usuario) {
        return usuarioService.altaUsuario(usuario);
    }
}
