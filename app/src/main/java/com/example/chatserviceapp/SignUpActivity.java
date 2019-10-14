package com.example.chatserviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText signupMail, signupPassword, confirmPassword;
    private ProgressDialog progressDialog;
    private Button signUp,backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MenuTheme);
        setContentView(R.layout.activity_sign_up);
        bindWidgets();
        bindListeners();
    }

    void bindWidgets() {
        signupMail = findViewById(R.id.signup_mail);
        signupPassword = findViewById(R.id.signup_password);
        confirmPassword = findViewById(R.id.confirm_signup_password);
        signUp = findViewById(R.id.signup_button);
        backButton = findViewById(R.id.backlogin_button);
        progressDialog = new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    void bindListeners() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail =signupMail.getText().toString().trim();
                String pass=signupPassword.getText().toString().trim();
                String confirm=confirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)){
                    Toast.makeText(SignUpActivity.this,"Enter all fields properly",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!pass.equals(confirm)){
                    Toast.makeText(SignUpActivity.this,"Passwords do not match",Toast.LENGTH_LONG).show();
                    return;
                }
                signup(mail,pass);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
            }
        });
    }
    void signup(String mail,String pass){
        progressDialog.setTitle("Signing you up");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                progressDialog.dismiss();
                Toast.makeText(SignUpActivity.this,"Signed in now",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(SignUpActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
