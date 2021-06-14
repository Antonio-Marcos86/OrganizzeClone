package com.br.organizzeclone.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.organizzeclone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import config.ConfiguracaoFirebase;
import model.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoNome,campoSenha,campoEmail;
    private Button buttonCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializaComponentes();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // recupera o que foi digitado no xml
                String nome = campoNome.getText().toString();
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                // validar se os campos form preenchidos
                if(!nome.isEmpty()){
                    if(!email.isEmpty()){
                        if(!senha.isEmpty()){
                            usuario = new Usuario();
                            usuario.setNome(nome);
                            usuario.setEmail(email);
                            usuario.setSenha(senha);
                            cadastrarUsuario();

                        }else{
                            exibirMensagem("Preencha a senha!");
                        }
                    }else{
                        exibirMensagem("Preencha o email!");
                    }
                }else{
                    exibirMensagem("Preencha o nome!");
                }

            }
        });
    }

    public void cadastrarUsuario(){
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    exibirMensagem("Cadastro realizado com sucesso!");
                    finish();
                }else{
                    exibirMensagem("Erro ao cadastrar usuário!");
                }
            }
        });

    }
    private void exibirMensagem(String texto){
        Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
    }

    private void inicializaComponentes() {
        campoNome = findViewById(R.id.editName);
        campoEmail = findViewById(R.id.editEmailAddress);
        campoSenha = findViewById(R.id.editPassword);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
    }
}