package com.social.joanlouji.chatblo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class DashboardActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mUserRef;
    FirebaseUser user;
    ImageView allstaff,notificationicon,profileicon,paswordicon,chaticon,logouticon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        allstaff = findViewById(R.id.groupicon);
        notificationicon = findViewById(R.id.notificationicon);
        profileicon = findViewById(R.id.profileicon);
        paswordicon = findViewById(R.id.passwordicon);
        chaticon = findViewById(R.id.chaticon);
        logouticon = findViewById(R.id.logouticon);


        if (mAuth.getCurrentUser() != null) {


            mUserRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());

        }

        allstaff.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, AllUsersActivity.class);
                startActivity(intent);
            }
        });
        notificationicon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        profileicon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        paswordicon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {



            }
        });
        chaticon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
        logouticon.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent startIntent = new Intent(DashboardActivity.this, StartActivity.class);
                startActivity(startIntent);
                finish();
            }
        });

    }



    //click event for image icon

  /*  @Override
    protected void onResume() {
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(DashboardActivity.this, StartActivity.class));
            finish();
        }
        super.onResume();
    }*/
    @Override
    protected void onPause() {

        super.onPause();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null){

            sendToStart();

        } else {

            mUserRef.child("online").setValue("true");

        }

    }


    @Override
    protected void onStop() {
        super.onStop();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {

            mUserRef.child("online").setValue(ServerValue.TIMESTAMP);

        }

    }

    private void sendToStart() {

        Intent startIntent = new Intent(DashboardActivity.this, StartActivity.class);
        startActivity(startIntent);
        finish();

    }


}