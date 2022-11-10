package br.edu.ifpb.listadecontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifpb.listadecontatos.DAO.AppDatabase;
import br.edu.ifpb.listadecontatos.DAO.PessoaDAO;
import br.edu.ifpb.listadecontatos.R;
import br.edu.ifpb.listadecontatos.model.Pessoa;


public class CadastroPessoa extends AppCompatActivity {

    public EditText nome_pessoa, email_pessoa, telefone_pessoa;
    public String nome, email, telefone;
    public Button btn_adicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        this.btn_adicionar = (Button) findViewById(R.id.btn_adicionar);


        this.btn_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome_pessoa = (EditText) findViewById(R.id.nome_pessoa);
                email_pessoa = (EditText) findViewById(R.id.email_pessoa);
                telefone_pessoa = (EditText) findViewById(R.id.telefone_pessoa);

                nome = String.valueOf(nome_pessoa.getText());

                email = String.valueOf(email_pessoa.getText());

                telefone = String.valueOf(telefone_pessoa.getText());


                Pessoa pessoa = new Pessoa(nome, email, telefone);

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class,"contatos.sqlite"
                ).allowMainThreadQueries().build();


                PessoaDAO pessoaDAO = db.pessoaDAO();

                pessoaDAO.inserirPessoa(pessoa);

                Intent intent =
                        new Intent(CadastroPessoa.this,
                                MainActivity.class);
                startActivity(intent);

                Log.i("irTelaListar", "O botão listar foi clicado");
                Intent telaListar =
                        new Intent(CadastroPessoa.this, MainActivity.class);
                startActivity(telaListar);

            }
        });

    }
}