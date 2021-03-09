package org.bandtec.grupo06.controllers;

import org.bandtec.grupo06.Usuario;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    private final List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<>();
    }

    @PostMapping("/usuario/login")
    public String logar(@RequestBody Usuario payload,
                        HttpSession session) {
        if (listaUsuarios.size() == 0) {
            listaUsuarios.add(new Usuario("user.teste",
                    "User Teste",
                    "teste",
                    "user@teste.com.br"));
            listaUsuarios.get(listaUsuarios.size() - 1).setId(listaUsuarios.size());
        }
        if (session.getAttribute("user") == null) {
            for (Usuario u : listaUsuarios) {
                if (u.getLogin().equals(payload.getLogin())
                        && u.getSenha().equals(payload.getSenha())) {

                    session.setAttribute("user", payload.getLogin());
                    return "Logado com sucesso!";
                }
            }
        } else {
            return "Usuario já está logado";
        }
        return "Falha na autenticação!";
    }

    @PostMapping("/usuario/deslogar")
    public String deslogar(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return "Deslogado com sucesso";
        } else {
            return "Você não está logado para tentar deslogar";
        }
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
            return "Usuário cadastrado com sucesso!";
        }

    }

    @GetMapping("/usuario")
    public Object exibirUsuarios(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return listaUsuarios;
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
    }

    @GetMapping("/usuario/{id}")
    public Object getUsuario(@PathVariable Integer id,
                             HttpSession session) {
        if (session.getAttribute("user") != null) {
            for (Usuario u : listaUsuarios) {
                if (u.getId().equals(id)) {
                    return u;
                }
            }
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
        return "Usuario não encontrado";
    }

    @DeleteMapping("/usuario/{id}")
    public String deleteUsuario(@PathVariable Integer id,
                                HttpSession session) {
        if (session.getAttribute("user") != null) {
            for (Usuario u : listaUsuarios) {
                if (u.getId().equals(id)) {
                    listaUsuarios.remove(u.getId() - 1);
                    return "Usuario Removido";
                }
            }
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
        return "Usuario não encontrado";
    }

}
