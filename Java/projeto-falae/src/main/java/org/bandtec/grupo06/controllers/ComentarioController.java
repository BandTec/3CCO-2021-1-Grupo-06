package org.bandtec.grupo06.controllers;

import org.bandtec.grupo06.Comentario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

public class ComentarioController {

    private List<Comentario> listaComentario;

    public ComentarioController() {
        listaComentario = new ArrayList<>();
    }

    public Boolean comentarIdeia(Comentario comentario) {
        listaComentario.add(comentario);
        return true;
    }

    public void mostrarComentarios() {
        for (Comentario c : listaComentario) {
            System.out.println(c);
        }
    }
}
