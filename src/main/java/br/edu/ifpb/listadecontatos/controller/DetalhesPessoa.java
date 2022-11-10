package br.edu.ifpb.listadecontatos.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifpb.listadecontatos.DAO.AppDatabase;
import br.edu.ifpb.listadecontatos.DAO.PessoaDAO;
import br.edu.ifpb.listadecontatos.R;
import br.edu.ifpb.listadecontatos.model.Pessoa;

public class DetalhesPessoa extends AppCompatActivity {

    private TextView nome_pessoa, email_pessoa, telefone_pessoa;
    private Button editar, excluir;

    private Pessoa pessoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pessoa);

        Intent intentAnterior = getIntent();

        pessoa = intentAnterior.getExtras().getParcelable("pessoa");

        nome_pessoa = (TextView) findViewById(R.id.nome_pessoa);
        email_pessoa = (TextView) findViewById(R.id.email_pessoa);
        telefone_pessoa = (TextView) findViewById(R.id.telefone_pessoa);

        editar = (Button) findViewById(R.id.editar_pessoa);
        excluir = (Button) findViewById(R.id.excluir_pessoa);

        //Setando os valores nos respectivos TextViews
        nome_pessoa.setText(pessoa.getNome());
        email_pessoa.setText(pessoa.getTelefone());
        telefone_pessoa.setText(pessoa.getEmail());

        editar.setOnClickListener(new BotaoEditarPessoaListener());
        excluir.setOnClickListener(new BotaoExcluirPessoaListener());


    }
    private class BotaoEditarPessoaListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent edicaPessoaActivity =
                    new Intent(DetalhesPessoa.this,
                            EdicaoPessoa.class);

            edicaPessoaActivity.putExtra("pessoa",pessoa);

            startActivity(edicaPessoaActivity);
        }
    }

    private class BotaoExcluirPessoaListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            AlertDialog.Builder alertDialogBuilder = new
                    AlertDialog.Builder(view.getContext());
            alertDialogBuilder.setTitle("Excluindo pessoa");
            alertDialogBuilder.setMessage("Você tem certeza que quer excluir?");


            alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    AppDatabase db;
                    PessoaDAO pessoaDAO;

                    db = Room.databaseBuilder(
                            getApplicationContext(),
                            AppDatabase.class,
                            "contatos.sqlite"
                    ).allowMainThreadQueries().build();

                    pessoaDAO = db.pessoaDAO();


                    pessoaDAO.excluirPessoa(pessoa);

                    Intent listaPessoasActivity = new Intent(view.getContext(),MainActivity.class);
                    startActivity(listaPessoasActivity);
                }
            });


            alertDialogBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });


            alertDialogBuilder.create();

            alertDialogBuilder.show();

        }
    }




}