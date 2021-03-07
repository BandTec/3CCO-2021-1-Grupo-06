import java.util.ArrayList;
import java.util.List;

public class IdeiaController {

    private List<Ideia> listaIdeia;

    public IdeiaController(){
        listaIdeia = new ArrayList<Ideia>();
    }

    public void criarIdeia(Ideia i){
        System.out.println("Ideia enviada com sucesso!");
        listaIdeia.add(i);
    }

    public Boolean reportarIdeia(Integer id){
        if(listaIdeia.size() <= id){
            listaIdeia.get(id);
            System.out.println("Ideia reportada com sucesso!");
            return true;
        }
        return false;
    }

    public void mostrarIdeias(){
        for(Ideia i : listaIdeia){
            System.out.println(i);
        }
    }
}
