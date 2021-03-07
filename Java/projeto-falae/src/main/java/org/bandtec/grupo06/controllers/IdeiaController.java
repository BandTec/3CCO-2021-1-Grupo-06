package org.bandtec.grupo06.controllers;

import org.bandtec.grupo06.Ideia;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class IdeiaController {

    private List<Ideia> listaIdeia;

    public IdeiaController() {
        listaIdeia = new ArrayList<>();
    }

    @PostMapping("/ideia")
    public String criarIdeia(@RequestBody Ideia i) {
        listaIdeia.add(i);
        listaIdeia.get(listaIdeia.size() - 1).setId(listaIdeia.size());
        return "Ideia enviada com sucesso";
    }

    @GetMapping("/ideia")
    public List<Ideia> mostrarIdeias() {
        return listaIdeia;
    }

    @GetMapping("/ideia/{id}")
    public Object getIdeia(@PathVariable Integer id) {
        for (Ideia i : listaIdeia) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return "Ideia não encontrada";
    }

    @PostMapping("/report/{id}")
    public String reportarIdeia(@PathVariable Integer id) {
        if (listaIdeia.size() >= id) {
            Integer valor = listaIdeia.get(id - 1).getReports();
            listaIdeia.get(id - 1).setReports(valor + 1);
            return "Ideia reportada com sucesso!";
        }
        return "Ideia não encontrada!";
    }

    @PostMapping("/ideia/{id}/{opiniao}")
    public String opinar(@PathVariable Integer id,
                         @PathVariable Boolean opiniao) {
        if (listaIdeia.size() >= id) {
            listaIdeia.get(id - 1).manterOpiniao(opiniao);
            return "Opinião anotada";
        }
        return "Ideia não encontrada";
    }
}
