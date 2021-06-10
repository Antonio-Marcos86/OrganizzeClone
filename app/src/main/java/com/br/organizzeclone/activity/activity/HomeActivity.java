package com.br.organizzeclone.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.organizzeclone.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void adicionarDespesa(View view){
        startActivity(new Intent(this,DespesaActivity.class));
    }
    public void adicionarReceita(View view){
        startActivity(new Intent(this,ReceitasActivity.class));
    }
}