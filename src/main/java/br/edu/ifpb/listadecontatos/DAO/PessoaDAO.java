package br.edu.ifpb.listadecontatos.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.ifpb.listadecontatos.model.Pessoa;

@Dao
public interface PessoaDAO {
    @Query("SELECT * FROM pessoa")
    List<Pessoa> getPessoas();

    @Query(("SELECT * FROM pessoa WHERE id=:id"))
    Pessoa getPessoaById(int id);

    @Insert
    void inserirPessoa(Pessoa... pessoas);

    @Update
    void atualizarPessoa(Pessoa pessoa);

    @Delete
    void excluirPessoa(Pessoa pessoa);

}