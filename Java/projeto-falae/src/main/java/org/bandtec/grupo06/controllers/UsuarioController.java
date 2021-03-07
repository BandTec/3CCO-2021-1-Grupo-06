package org.bandtec.grupo06.controllers;

import org.bandtec.grupo06.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {
    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<>();
    }

    @PostMapping("/usuario/login")
    public String logar(@RequestBody Usuario payload) {
        for (Usuario u : listaUsuarios) {
            if (u.getLogin().equals(payload.getLogin())
                    && !u.getLogado()) {
                if (u.getLogin().equals(payload.getLogin())
                        && u.getSenha().equals(payload.getSenha())) {
                    u.setLogado(true);
                    return "Logado com sucesso!";
                }
            } else {
                return "Usuario já está logado";
            }
        }
        return "Falha na autenticação!";
    }

    @PostMapping("/usuario/deslogar")
    public String deslogar(@RequestBody Usuario payload) {
        for (Usuario u : listaUsuarios) {
            if (u.getLogado() && u.getLogin().equals(payload.getLogin())) {
                u.setLogado(false);
                return "Deslogado com sucesso!";
            }
        }
        return "Esse usuario não está logado!";
    }

    @PostMapping("/usuario")
    public String registrar(@RequestBody Usuario usuario) {

        if (listaUsuarios.stream()
                .anyMatch(login ->
                        usuario.getLogin().equals(login.getLogin()))) {
            return "Um usuario com esse login já está cadastrado";
        } else if (listaUsuarios.stream()
                .anyMatch(email ->
                        usuario.getEmail().equals(email.getEmail()))) {
            return "Um usuario com esse email já está cadastrado";
        } else {
            listaUsuarios.add(usuario);
            listaUsuarios.get(listaUsuarios.size() - 1).setId(listaUsuarios.size());
        }

        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping("/usuario")
    public List<Usuario> exibirUsuarios() {
        return listaUsuarios;
    }

    @GetMapping("/usuario/{id}")
    public Object getUsuario(@PathVariable Integer id) {
        for (Usuario u : listaUsuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return "Usuario não encontrado";
    }

}
