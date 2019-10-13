package com.example.chatserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkUserStatus();

    }

    private void checkUserStatus(){
        if(firebaseAuth.getCurrentUser() == null){
            startActivity(new Intent(MainActivity.this,LogInActivity.class));
        }

        startActivity(new Intent(MainActivity.this,LogInActivity.class));
    }
}
