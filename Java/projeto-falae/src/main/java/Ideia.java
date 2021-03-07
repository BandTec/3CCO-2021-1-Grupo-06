import java.util.ArrayList;
import java.util.List;

public class Ideia extends Opiniao{
    private Integer id;
    private String titulo;
    private String descricao;
    private Usuario autor;

    public Ideia(String titulo, String descricao, Usuario autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getAutor() {
        return autor;
    }

    @Override
    public Integer manterOpiniao(Boolean valorOpiniao) {
        return super.manterOpiniao(valorOpiniao);
    }

    @Override
    public String toString() {
        return "Ideia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", autor=" + autor +
                '}';
    }
}
