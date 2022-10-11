package com.example.listacontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listacontatos.DAO.AppDatabase;
import com.example.listacontatos.DAO.PessoaDAO;
import com.example.listacontatos.R;
import com.example.listacontatos.model.Pessoa;

public class CadastrarPessoaLista extends AppCompatActivity {
        EditText nomePessoa, emailPessoa, telefonePessoa;
        String nome, email, telefone;
        Button btn_add;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastrar_pessoa_lista);

            this.nomePessoa = (EditText) findViewById(R.id.nome_pessoa);
            this.emailPessoa = (EditText) findViewById(R.id.email_pessoa);
            this.telefonePessoa = (EditText) findViewById(R.id.telefone_pessoa);

            this.btn_add = (Button) findViewById(R.id.btn_add);

            this.nome = nomePessoa.toString();
            this.email = emailPessoa.toString();
            this.telefone = telefonePessoa.toString();

            AppDatabase database = Room.databaseBuilder(
                    getApplicationContext(),
                    AppDatabase.class,
                    "contatos.sqlite"
            ).allowMainThreadQueries().build();

            PessoaDAO pessoaDAO = database.pessoaDAO();

            pessoaDAO.incerirPessoa(new Pessoa(nome, email, telefone));

            this.btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =
                            new Intent(CadastrarPessoaLista.this,
                                    MainActivity.class);
                    startActivity(intent);
                }

            });
        }
    }