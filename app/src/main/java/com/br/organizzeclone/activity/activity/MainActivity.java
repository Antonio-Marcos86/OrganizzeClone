package com.br.organizzeclone.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.organizzeclone.R;
import com.br.organizzeclone.activity.activity.CadastroActivity;
import com.br.organizzeclone.activity.activity.HomeActivity;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        setButtonBackVisible(false);
        setButtonNextVisible(false);
        addSlide(new FragmentSlide.Builder()
                .background(R.color.teal_700)
                .fragment(R.layout.intro_1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(R.color.teal_700)
                .fragment(R.layout.intro_2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(R.color.teal_700)
                .fragment(R.layout.intro_3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(R.color.teal_700)
                .fragment(R.layout.intro_4)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(R.color.teal_700)
                .fragment(R.layout.intro_5)
                .canGoForward(false)
                .build()
        );
    }
    public void btnEntrar(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }
    public void btncadastro(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }
}