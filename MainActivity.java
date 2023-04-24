package com.example.myapplication;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText emailEtv, passwordEtv;
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEtv = findViewById(R.id.emailEtv);
        passwordEtv = findViewById(R.id.passwordEtv);
        submitBtn=findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailEtv.getText().toString();
                String password=passwordEtv.getText().toString();

               boolean check = validateinfo(email, password);

               if (check==true){
                   Toast.makeText(getApplicationContext(), "Все окей!", Toast.LENGTH_SHORT).show();
                   MainActivity.this.onClick();
               }
               else {
                   Toast.makeText(getApplicationContext(), "перепроверь инфо", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
    private Boolean validateinfo(String email, String password){
        if(email.length()==0){
            emailEtv.requestFocus();
            emailEtv.setError("поле не можеть быть пустым");
            return false;
        }
        else if(!email.matches( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            emailEtv.requestFocus();
            emailEtv.setError("введи подходящий email");
            return false;
        }
        else if(password.length()<=5){
            passwordEtv.requestFocus();
            passwordEtv.setError("минимум 6 символов");
            return false;
        }
        else {
            return true;
        }
    }

    public void onClick() {

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name", emailEtv.getText().toString());
        intent.putExtra("password", passwordEtv.getText().toString());
        startActivity(intent);

    }
}



