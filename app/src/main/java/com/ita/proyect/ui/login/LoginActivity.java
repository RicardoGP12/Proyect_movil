package com.ita.proyect.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ita.proyect.MainActivity;
import com.ita.proyect.R;
import com.ita.proyect.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    Button ingresar;
    EditText correo, contraseña;
     FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        correo =findViewById(R.id.email);
        contraseña=findViewById(R.id.pass);
        ingresar= findViewById(R.id.iniciar);


        //ingresar = findViewById(R.id.Login);
        //correo = findViewById(R.id.username);
        //pass = findViewById(R.id.password);

        /*ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaiuser =correo.getText().toString().trim();
                String passuser = contraseña.getText().toString().trim();

                if (emaiuser.isEmpty() && passuser.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }else {
                    loginuser(emaiuser, passuser);
                }
            }
        });
    }

    private void loginuser(String emaiuser, String passuser) {
        mAuth.signInWithEmailAndPassword(emaiuser, passuser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error al iniciar seccion", Toast.LENGTH_SHORT).show();
            }
        });
    }


}