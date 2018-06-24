package com.app.fran.copanamo.entidades;

import android.graphics.drawable.Drawable;

import com.mikepenz.materialdrawer.Drawer;

import java.util.List;

public class Grupo {
    int id;
    String nome_grupo;
    String cam_img1;
    String cam_img2;
    String cam_img3;
    String cam_img4;
    String nome_selecao1;
    String nome_selecao2;
    String nome_selecao3;
    String nome_selecao4;
    int pontos_sel1,pontos_sel2,pontos_sel3,pontos_sel4;
    int vitorias_sel1,vitorias_sel2,vitorias_sel3,vitorias_sel4;
    int empates_sel1,empates_sel2,empates_sel3,empates_sel14;
    int derrotas_sel1,derrotas_sel2,derrotas_sel3,derrotas_sel4;
    String created_at;
    String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }

    public String getCam_img1() {
        return cam_img1;
    }

    public void setCam_img1(String cam_img1) {
        this.cam_img1 = cam_img1;
    }

    public String getCam_img2() {
        return cam_img2;
    }

    public void setCam_img2(String cam_img2) {
        this.cam_img2 = cam_img2;
    }

    public String getCam_img3() {
        return cam_img3;
    }

    public void setCam_img3(String cam_img3) {
        this.cam_img3 = cam_img3;
    }

    public String getCam_img4() {
        return cam_img4;
    }

    public void setCam_img4(String cam_img4) {
        this.cam_img4 = cam_img4;
    }

    public String getNome_selecao1() {
        return nome_selecao1;
    }

    public void setNome_selecao1(String nome_selecao1) {
        this.nome_selecao1 = nome_selecao1;
    }

    public String getNome_selecao2() {
        return nome_selecao2;
    }

    public void setNome_selecao2(String nome_selecao2) {
        this.nome_selecao2 = nome_selecao2;
    }

    public String getNome_selecao3() {
        return nome_selecao3;
    }

    public void setNome_selecao3(String nome_selecao3) {
        this.nome_selecao3 = nome_selecao3;
    }

    public String getNome_selecao4() {
        return nome_selecao4;
    }

    public void setNome_selecao4(String nome_selecao4) {
        this.nome_selecao4 = nome_selecao4;
    }

    public int getPontos_sel1() {
        return pontos_sel1;
    }

    public void setPontos_sel1(int pontos_sel1) {
        this.pontos_sel1 = pontos_sel1;
    }

    public int getPontos_sel2() {
        return pontos_sel2;
    }

    public void setPontos_sel2(int pontos_sel2) {
        this.pontos_sel2 = pontos_sel2;
    }

    public int getPontos_sel3() {
        return pontos_sel3;
    }

    public void setPontos_sel3(int pontos_sel3) {
        this.pontos_sel3 = pontos_sel3;
    }

    public int getPontos_sel4() {
        return pontos_sel4;
    }

    public void setPontos_sel4(int pontos_sel4) {
        this.pontos_sel4 = pontos_sel4;
    }

    public int getVitorias_sel1() {
        return vitorias_sel1;
    }

    public void setVitorias_sel1(int vitorias_sel1) {
        this.vitorias_sel1 = vitorias_sel1;
    }

    public int getVitorias_sel2() {
        return vitorias_sel2;
    }

    public void setVitorias_sel2(int vitorias_sel2) {
        this.vitorias_sel2 = vitorias_sel2;
    }

    public int getVitorias_sel3() {
        return vitorias_sel3;
    }

    public void setVitorias_sel3(int vitorias_sel3) {
        this.vitorias_sel3 = vitorias_sel3;
    }

    public int getVitorias_sel4() {
        return vitorias_sel4;
    }

    public void setVitorias_sel4(int vitorias_sel4) {
        this.vitorias_sel4 = vitorias_sel4;
    }

    public int getEmpates_sel1() {
        return empates_sel1;
    }

    public void setEmpates_sel1(int empates_sel1) {
        this.empates_sel1 = empates_sel1;
    }

    public int getEmpates_sel2() {
        return empates_sel2;
    }

    public void setEmpates_sel2(int empates_sel2) {
        this.empates_sel2 = empates_sel2;
    }

    public int getEmpates_sel3() {
        return empates_sel3;
    }

    public void setEmpates_sel3(int empates_sel3) {
        this.empates_sel3 = empates_sel3;
    }

    public int getEmpates_sel14() {
        return empates_sel14;
    }

    public void setEmpates_sel14(int empates_sel14) {
        this.empates_sel14 = empates_sel14;
    }

    public int getDerrotas_sel1() {
        return derrotas_sel1;
    }

    public void setDerrotas_sel1(int derrotas_sel1) {
        this.derrotas_sel1 = derrotas_sel1;
    }

    public int getDerrotas_sel2() {
        return derrotas_sel2;
    }

    public void setDerrotas_sel2(int derrotas_sel2) {
        this.derrotas_sel2 = derrotas_sel2;
    }

    public int getDerrotas_sel3() {
        return derrotas_sel3;
    }

    public void setDerrotas_sel3(int derrotas_sel3) {
        this.derrotas_sel3 = derrotas_sel3;
    }

    public int getDerrotas_sel4() {
        return derrotas_sel4;
    }

    public void setDerrotas_sel4(int derrotas_sel4) {
        this.derrotas_sel4 = derrotas_sel4;
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
