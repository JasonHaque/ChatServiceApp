package com.example.chatserviceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.chatserviceapp.LogInActivity.userID;

public class ProfileActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;
    private Button backToChat;
    private FirebaseAuth firebaseAuth;
    private ImageView profileImage;
    private TextView userView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bindWidgets();
        bindListeners();
        userView.setText("Welcome User \n "+userID);
        profileImage.setImageResource(R.drawable.profile);
    }
    void bindWidgets(){
        firebaseAuth=FirebaseAuth.getInstance();
        userView=findViewById(R.id.user_view);
        backToChat=findViewById(R.id.chat_back_button);
        profileImage=findViewById(R.id.profile_image);
    }

    void bindListeners(){
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });

        backToChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ChatViewActivity.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            profileImage.setImageURI(selectedImage);
        }
    }
}

