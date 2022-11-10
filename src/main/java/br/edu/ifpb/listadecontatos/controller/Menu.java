package br.edu.ifpb.listadecontatos.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.listadecontatos.R;
public class Menu extends AppCompatActivity {
    public Button buttonListar;
    public Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.buttonListar = (Button) findViewById(R.id.buttonListar);
        this.buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);


        this.buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("irTelaListar", "O botão listar foi clicado");
                Intent telaListar =
                        new Intent(Menu.this, MainActivity.class);
                startActivity(telaListar);
            }
        });


        this.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("irTelaCadastrar", "O botão cadastrar foi clicado");
                Intent telaCadastrar =
                        new Intent(Menu.this, CadastroPessoa.class);
                startActivity(telaCadastrar);
            }
        });

    }
}