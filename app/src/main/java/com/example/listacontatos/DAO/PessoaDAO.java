package com.example.listacontatos.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.listacontatos.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PessoaDAO {
    //CREATE
    @Insert
    void incerirPessoa(Pessoa... pessoas);

    //READ

    @Query("SELECT * FROM pessoa")
    List<Pessoa> getPessoas();


}