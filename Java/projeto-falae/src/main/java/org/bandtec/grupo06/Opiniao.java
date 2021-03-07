package org.bandtec.grupo06;

public abstract class Opiniao {
    private Integer likes;
    private Integer dislike;

    public Opiniao() {
        likes = 0;
        dislike = 0;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislike() {
        return dislike;
    }

    public Integer manterOpiniao(Boolean valorOpiniao) {
        if (valorOpiniao) {
            System.out.println("Seu like foi contabilizada com sucesso!");
            return likes++;
        } else {
            System.out.println("Seu dislike foi contabilizada com sucesso!");
            return dislike++;
        }
    }
}
