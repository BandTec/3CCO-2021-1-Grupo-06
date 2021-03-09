package org.bandtec.grupo06.controllers;

import org.bandtec.grupo06.Ideia;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class IdeiaController {

    private List<Ideia> listaIdeia;

    public IdeiaController() {
        listaIdeia = new ArrayList<>();
    }

    @PostMapping("/ideia")
    public String criarIdeia(@RequestBody Ideia i,
                             HttpSession session) {
        if (session.getAttribute("user") != null) {
            listaIdeia.add(i);
            listaIdeia.get(listaIdeia.size() - 1).setId(listaIdeia.size());
            listaIdeia.get(listaIdeia.size() - 1).setAutor((String) session.getAttribute("user"));
            return "Ideia enviada com sucesso";
        } else {
            return "Para criar uma ideia, você precisa estar logado";
        }

    }

    @GetMapping("/ideia")
    public Object mostrarIdeias(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return listaIdeia;
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
    }

    @GetMapping("/ideia/{id}")
    public Object getIdeia(@PathVariable Integer id,
                           HttpSession session) {
        if (session.getAttribute("user") != null) {
            for (Ideia i : listaIdeia) {
                if (i.getId().equals(id)) {
                    return i;
                }
            }
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
        return "Ideia não encontrada";
    }

    @PostMapping("/report/{id}")
    public String reportarIdeia(@PathVariable Integer id,
                                HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (listaIdeia.size() >= id) {
                Integer valor = listaIdeia.get(id - 1).getReports();
                listaIdeia.get(id - 1).setReports(valor + 1);
                return "Ideia reportada com sucesso!";
            }
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
        return "Ideia não encontrada!";
    }

    @PostMapping("/ideia/{id}/{opiniao}")
    public String opinar(@PathVariable Integer id,
                         @PathVariable Boolean opiniao,
                         HttpSession session) {
        if (session.getAttribute("user") != null) {
            if (listaIdeia.size() >= id) {
                listaIdeia.get(id - 1).manterOpiniao(opiniao);
                return "Opinião anotada";
            }
            return "Ideia não encontrada";
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
    }

    @DeleteMapping("/ideia/{id}")
    public String deleteIdeia(@PathVariable Integer id, HttpSession session) {
        if (session.getAttribute("user") != null) {
            for (Ideia i : listaIdeia) {
                if (i.getId().equals(id)) {
                    listaIdeia.remove(i.getId() - 1);
                    return "Ideia Removida";
                }
            }
        } else {
            return "Para executar essa ação, você precisa estar logado";
        }
        return "Ideia não encontrada";
    }
}
