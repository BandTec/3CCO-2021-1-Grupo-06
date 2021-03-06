package org.bandtec.grupo06;

public class Ideia extends Opiniao {
    private Integer id;
    private String titulo;
    private String descricao;
    private String autor;
    private Integer reports = 0;

    public Ideia(String titulo, String descricao, String autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getReports() {
        return reports;
    }

    public void setReports(Integer reports) {
        this.reports = reports;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public Integer manterOpiniao(Boolean valorOpiniao) {
        return super.manterOpiniao(valorOpiniao);
    }

    @Override
    public String toString() {
        return "org.bandtec.grupo06.Ideia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", autor=" + autor +
                '}';
    }
}
