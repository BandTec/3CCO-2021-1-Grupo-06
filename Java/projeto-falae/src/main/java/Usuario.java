import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Integer id;
    private String login;
    private String nome;
    private String senha;
    private String email;
    private List<Opiniao> curtidos;

    public Usuario(String login, String nome, String senha, String email) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public List<Opiniao> getCurtidos() {
        return curtidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", curtidos=" + curtidos +
                '}';
    }
}
