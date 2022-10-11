package com.example.listacontatos.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nome")
    public String nome;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "telefone")
    public String telefone;


    public Pessoa(){

    }

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
