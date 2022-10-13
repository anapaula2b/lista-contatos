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
        public EditText nomePessoa, emailPessoa, telefonePessoa;
        public String nome, email, telefone;
        public Button btn_add;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastrar_pessoa_lista);


            this.btn_add = (Button) findViewById(R.id.btn_add);

            this.btn_add.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {

                    nomePessoa = (EditText) findViewById(R.id.nome_pessoa);
                    emailPessoa = (EditText) findViewById(R.id.email_pessoa);
                    telefonePessoa = (EditText) findViewById(R.id.telefone_pessoa);

                    nome = String.valueOf(nomePessoa.getText());
                    email = String.valueOf(emailPessoa.getText());
                    telefone = String.valueOf(telefonePessoa.getText());

                    Pessoa pessoa = new Pessoa(nome, email, telefone);

                    AppDatabase database = Room.databaseBuilder(
                            getApplicationContext(),
                            AppDatabase.class,
                            "contatos.sqlite"
                    ).allowMainThreadQueries().build();

                    PessoaDAO pessoaDAO = database.pessoaDAO();

                    pessoaDAO.incerirPessoa(pessoa);

                    Intent intent =
                            new Intent(CadastrarPessoaLista.this,
                                    MainActivity.class);
                    startActivity(intent);
                }

            });
        }
    }