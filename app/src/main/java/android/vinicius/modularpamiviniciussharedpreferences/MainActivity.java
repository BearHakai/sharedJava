package android.vinicius.modularpamiviniciussharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText email, senha;
    Button gravar, cadastro;

    public static final String NOME_ARQ = "cliente";
    SharedPreferences preferences;
    SharedPreferences.Editor dados;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();
        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = getSharedPreferences(NOME_ARQ, MODE_PRIVATE);
                dados = preferences.edit();

                String varEmail = email.getText().toString();
                String varSenha = senha.getText().toString();

                dados.putString("email", varEmail);
                dados.putString("senha", varSenha);
                dados.apply();

                boolean isOk = validarCampos();

                if(isOk){
                    Toast.makeText(MainActivity.this, "Campos Digitados", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Preencha Todos os Campos", Toast.LENGTH_LONG).show();
                }

                /*if(varEmail.equals("")){
                    Toast.makeText(MainActivity.this, "Falta o Email", Toast.LENGTH_LONG).show();
                }

                else if(varSenha.equals("")){
                    Toast.makeText(MainActivity.this, "Falta a Senha", Toast.LENGTH_LONG).show();
                }

                else{
                    Toast.makeText(MainActivity.this, "Cadastro Realizado com Sucesso", Toast.LENGTH_LONG).show();
                }*/

                //Toast.makeText(MainActivity.this, "Cadastro Realizado com Sucesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("NewApi")
    private boolean validarCampos(){
        /*boolean camposValidados = true;
        if (email.getText().toString().isEmpty()){
            camposValidados = false;
            email.setError("Digite o Email");
        }

        if (senha.getText().toString().isEmpty()){
            camposValidados = false;
            senha.setError("Digite a Senha");
        }
        return camposValidados;*/

        return (!email.getText().toString().isEmpty())
                && !senha.getText().toString().isEmpty();
    }

    private void initComponents() {
        senha = findViewById(R.id.edt_senha);
        email = findViewById(R.id.edt_email);
        gravar = findViewById(R.id.btn_gravar);
        cadastro = findViewById(R.id.btn_cadastrar);
    }
}