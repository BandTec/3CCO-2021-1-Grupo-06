import java.util.ArrayList;
import java.util.List;

public class Comentario extends Opiniao{
    private Integer id;
    private String texto;
    private Usuario autor;
    private Ideia ideia;
    private List<Comentario> listaComentario = new ArrayList<>();

    public Comentario(String texto, Usuario autor, Ideia ideia) {
        this.texto = texto;
        this.autor = autor;
        this.ideia = ideia;
    }

    public Integer getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Ideia getIdeia() {
        return ideia;
    }

    @Override
    public Integer manterOpiniao(Boolean valorOpiniao) {
        return super.manterOpiniao(valorOpiniao);
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", autor=" + autor +
                ", ideia=" + ideia +
                ", listaComentario=" + listaComentario +
                '}';
    }
}
