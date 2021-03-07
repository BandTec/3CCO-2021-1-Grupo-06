import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> listaUsuarios;

    public UsuarioController() {
        listaUsuarios = new ArrayList<Usuario>();
    }

    public boolean logar(String login, String senha){
        for (Usuario u : listaUsuarios){
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                System.out.println("Logado com sucesso!");
                return true;
            }
        }
        System.out.println("Falha na autenticação!");
        return false;
    }

    public void registrar(Usuario usuario){
        System.out.println("Usuário cadastrado com sucesso!");
        listaUsuarios.add(usuario);
    }

    public void exibirUsuarios(){
        for(Usuario u : listaUsuarios){
            System.out.println(u);
        }
    }

}
