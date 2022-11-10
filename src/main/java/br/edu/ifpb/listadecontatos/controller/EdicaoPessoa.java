package br.edu.ifpb.listadecontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifpb.listadecontatos.DAO.AppDatabase;
import br.edu.ifpb.listadecontatos.DAO.PessoaDAO;
import br.edu.ifpb.listadecontatos.R;
import br.edu.ifpb.listadecontatos.model.Pessoa;

public class EdicaoPessoa extends AppCompatActivity {

    private EditText nome_pessoa, telefone_pessoa, email_pessoa;
    private Pessoa pessoa;
    private Button atualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_pessoa);

        Intent intentAnterior = getIntent();

        pessoa = intentAnterior.getExtras().getParcelable("pessoa");

        nome_pessoa = (EditText) findViewById(R.id.nome_pessoa);
        email_pessoa = (EditText) findViewById(R.id.email_pessoa);
        telefone_pessoa = (EditText) findViewById(R.id.telefone_pessoa);

        atualizar = (Button) findViewById(R.id.atualizar);


        nome_pessoa.setText(pessoa.getNome());
        telefone_pessoa.setText(pessoa.getTelefone());
        email_pessoa.setText(pessoa.getEmail());

        atualizar.setOnClickListener(new BotaoAtualizarCadastroListener());

    }

    private class BotaoAtualizarCadastroListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String nomePessoa = String.valueOf(nome_pessoa.getText());

            String telefonePessoa =
                    String.valueOf(telefone_pessoa.getText());

            String emailPessoa = String.valueOf(email_pessoa.getText());

            AppDatabase db = Room.databaseBuilder(
                    getApplicationContext(),
                    AppDatabase.class,
                    "contatos.sqlite"
            ).allowMainThreadQueries().build();

            PessoaDAO pessoaDAO = db.pessoaDAO();

            pessoa.setNome(nomePessoa);
            pessoa.setTelefone(telefonePessoa);
            pessoa.setEmail(emailPessoa);


            pessoaDAO.atualizarPessoa(pessoa);


            Intent detalhesPessoa =
                    new Intent(EdicaoPessoa.this,
                            DetalhesPessoa.class);

            detalhesPessoa.putExtra("pessoa",pessoa);
            startActivity(detalhesPessoa);
        }
    }




}