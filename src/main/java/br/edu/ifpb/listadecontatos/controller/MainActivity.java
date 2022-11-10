package br.edu.ifpb.listadecontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.ifpb.listadecontatos.DAO.AppDatabase;
import br.edu.ifpb.listadecontatos.DAO.PessoaDAO;
import br.edu.ifpb.listadecontatos.R;
import br.edu.ifpb.listadecontatos.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    private ListView lv_contatos;
    private  ArrayList<Pessoa> pessoas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "contatos.sqlite"
        ).allowMainThreadQueries().build();

        PessoaDAO pessoaDAO = database.pessoaDAO();

        pessoas = (ArrayList<Pessoa>) pessoaDAO.getPessoas();

        ListaContatosAdapter listaContatosAdapter = new ListaContatosAdapter(this, pessoas);

        this.lv_contatos = (ListView) findViewById(R.id.lv_contatos);

        this.lv_contatos.setAdapter(listaContatosAdapter);

        lv_contatos.setOnItemClickListener(new ListaPessoasItemListener());



    }

    private class ListaPessoasItemListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            Intent detalhesPessoa =
                    new Intent(MainActivity.this,
                            DetalhesPessoa.class);


            Pessoa pessoa = pessoas.get(i);

            detalhesPessoa.putExtra("pessoa",pessoa);

            startActivity(detalhesPessoa);
        }
    }


}