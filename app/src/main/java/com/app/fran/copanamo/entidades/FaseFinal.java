package com.app.fran.copanamo.entidades;

public class FaseFinal {

    private int id;
    private String data;
    private String horario;
    private String url_img1;
    private String url_img2;
    private String nome_sel1;
    private String nome_sel2;
    private String placar1;
    private String placar2;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getUrl_sel1() {
        return url_img1;
    }

    public void setUrl_sel1(String url_sel1) {
        this.url_img1 = url_sel1;
    }

    public String getUrl_sel2() {
        return url_img2;
    }

    public void setUrl_sel2(String url_sel2) {
        this.url_img2 = url_sel2;
    }

    public String getNome_sel1() {
        return nome_sel1;
    }

    public void setNome_sel1(String nome_sel1) {
        this.nome_sel1 = nome_sel1;
    }

    public String getNome_sel2() {
        return nome_sel2;
    }

    public void setNome_sel2(String nome_sel2) {
        this.nome_sel2 = nome_sel2;
    }

    public String getPlacar1() {
        return placar1;
    }

    public void setPlacar1(String placar1) {
        this.placar1 = placar1;
    }

    public String getPlacar2() {
        return placar2;
    }

    public void setPlacar2(String placar2) {
        this.placar2 = placar2;
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
