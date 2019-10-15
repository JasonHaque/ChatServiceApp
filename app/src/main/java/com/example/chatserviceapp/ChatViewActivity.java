package com.example.chatserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ChatViewActivity extends AppCompatActivity {

//    CircleImageView pro_img;
//    TextView usern;
//    FirebaseUser firebaseUser;
//    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);

//        pro_img=findViewById(R.id.profile_image);
//        usern=findViewById(R.id.user_name);
//
//        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
//        reference= FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                User user=dataSnapshot.getValue(User.class);
//                usern.setText(user.getUsername());
//                if(user.getImageURL().equals("default")){
//                    pro_img.setImageResource(R.drawable.profile);
//                }
//                else{
//                    Glide.with(ChatViewActivity.this).load(user.getImageURL()).into(pro_img);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int a=item.getItemId();
        if(a==R.id.lo_out)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(ChatViewActivity.this, LogInActivity.class));
            finish();
            return true;
        }
        else if(a==R.id.prof)
        {
            startActivity(new Intent(ChatViewActivity.this, ProfileActivity.class));
            return true;
        }
        return false;
    }
}
