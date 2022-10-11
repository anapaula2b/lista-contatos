package com.example.listacontatos.DAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.listacontatos.model.Pessoa;


@Database(entities = {Pessoa.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract PessoaDAO pessoaDAO();

}
