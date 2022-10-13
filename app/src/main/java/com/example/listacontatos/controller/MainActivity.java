package com.example.listacontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listacontatos.DAO.AppDatabase;
import com.example.listacontatos.DAO.PessoaDAO;
import com.example.listacontatos.R;
import com.example.listacontatos.model.Pessoa;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView lv_contatos;
    private Button btn_adicionar;


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

        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) pessoaDAO.getPessoas();

        ListaContatosAdapter listaPessoasAdapter = new ListaContatosAdapter(this, pessoas);

        this.lv_contatos = (ListView) findViewById(R.id.lv_contatos);

        this.lv_contatos.setAdapter(listaPessoasAdapter);






    }
}