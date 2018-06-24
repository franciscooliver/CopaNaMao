package com.app.fran.copanamo.entidades;

public class Estadio {
    int id;
    private String nome_estadio;
    private String descricao;
    private String url_img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_estadio() {
        return nome_estadio;
    }

    public void setNome_estadio(String nome_estadio) {
        this.nome_estadio = nome_estadio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}
