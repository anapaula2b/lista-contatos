package br.edu.ifpb.listadecontatos.DAO;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.edu.ifpb.listadecontatos.model.Pessoa;

@Database(entities = {Pessoa.class},version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PessoaDAO pessoaDAO();
}
