package com.example.chatserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private Button directToSignup,loginButton;
    private EditText loginMail,loginPassword;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        bindWidgets();
        bindListeners();
    }

    void bindWidgets(){
        directToSignup=findViewById(R.id.signup_transfer);
        loginMail=findViewById(R.id.login_mail);
        loginPassword=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.login_button);
        progressDialog = new ProgressDialog(this);
    }

    void bindListeners(){
        directToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=loginMail.getText().toString();
                String pass = loginPassword.getText().toString();
                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LogInActivity.this,"Fill up Email And Password Properly", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}
