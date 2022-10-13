package com.example.listacontatos.controller;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listacontatos.R;
import com.example.listacontatos.model.Pessoa;

import java.util.ArrayList;


public class ListaContatosAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<Pessoa> pessoas;

    public ListaContatosAdapter(Context contexto, ArrayList<Pessoa> pessoas) {
        this.contexto = contexto;
        this.pessoas = pessoas;
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int i) {
        return pessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.contexto);

        if (view == null){
            view = inflater.inflate(R.layout.item_lista, viewGroup, false);
        }

        Pessoa pessoaAtual = (Pessoa) getItem(i);
        //ImageView fotoPessoa = view.findViewById(R.id.imgPessoa);
        TextView tvNomePessoa = view.findViewById(R.id.tv_nome_pessoa);
        TextView tvEmailPessoa = view.findViewById(R.id.tv_email_pessoa);
        TextView tvTelefonePessoa = view.findViewById(R.id.tv_telefone_pessoa);

        //fotoPessoa.setImageResource(pessoaAtual.getDrawableImage());
        tvNomePessoa.setText(pessoaAtual.getNome());
        tvEmailPessoa.setText(pessoaAtual.getEmail());
        tvTelefonePessoa.setText(pessoaAtual.getTelefone());


        return view;

    }
}
