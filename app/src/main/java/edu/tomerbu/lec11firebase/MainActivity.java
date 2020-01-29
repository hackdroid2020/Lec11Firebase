package edu.tomerbu.lec11firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //callback when our user is Logged in / Logged out:
    //in onResume (add the listener)
    //in onPause (remove the listener)
    FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            //if the user is null -> go login:
            if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    //Life - cycle:
    //in onResume (add the listener)
    @Override
    protected void onResume() {
        super.onResume();

        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    //Life - cycle:
    //in onPause (remove the listener)
    @Override
    protected void onPause() {
        super.onPause();
        FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //if we don't have a user -> go Login
        //sign out
        findViewById(R.id.button_logout).setOnClickListener(v -> logout());

        //sender ID:

        //if we have a user:
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            FirebaseDAO.shared.saveMessage(new Message("Text", null, uid));
        }

    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
    }
}
