package com.app.fran.copanamo.entidades;

import android.graphics.drawable.Drawable;

public class Noticia {

    int id;
    String url_img;
    String titulo_noticia;
    String conteudo_noticia;
    String created_at;
    String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getTitulo_noticia() {
        return titulo_noticia;
    }

    public void setTitulo_noticia(String titulo_noticia) {
        this.titulo_noticia = titulo_noticia;
    }

    public String getConteudo_noticia() {
        return conteudo_noticia;
    }

    public void setConteudo_noticia(String conteudo_noticia) {
        this.conteudo_noticia = conteudo_noticia;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
