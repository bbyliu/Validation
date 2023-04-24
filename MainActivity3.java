package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    EditText logEdit;
    EditText passEdit;
    Button newEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        logEdit = (EditText) findViewById(R.id.logEdit);
        passEdit = (EditText) findViewById(R.id.passEdit);
        newEdit = (Button)  findViewById(R.id.newEdit);



        newEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=logEdit.getText().toString();
                String password=passEdit.getText().toString();

                boolean check = validateinfo(email, password);

                if (check==true){
                    Toast.makeText(getApplicationContext(), "Все окей!", Toast.LENGTH_SHORT).show();
                    newinfo();
                }
                else {
                    Toast.makeText(getApplicationContext(), "перепроверь инфо", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateinfo(String email, String password){
        if(email.length()==0){
            logEdit.requestFocus();
            logEdit.setError("поле не можеть быть пустым");
            return false;
        }
        else if(!email.matches( "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            logEdit.requestFocus();
            logEdit.setError("введи подходящий email");
            return false;
        }
        else if(password.length()<=5){
            passEdit.requestFocus();
            passEdit.setError("минимум 6 символов");
            return false;
        }
        else {
            return true;
        }
    }
    public void back2 (View v){
//        Intent intent = new Intent(this, MainActivity2.class);
//        startActivity(intent);
        finish();
    }
    private void newinfo(){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("nameNew", logEdit.getText().toString());
        intent.putExtra("passwordNew", passEdit.getText().toString());
        startActivity(intent);
    }
}