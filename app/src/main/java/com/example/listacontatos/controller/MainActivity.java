package com.example.listacontatos.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ListView;

import com.example.listacontatos.DAO.AppDatabase;
import com.example.listacontatos.DAO.PessoaDAO;
import com.example.listacontatos.R;
import com.example.listacontatos.model.Pessoa;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView lv_contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        this.lv_contatos = (ListView) findViewById(R.id.lv_contatos);


    }
}