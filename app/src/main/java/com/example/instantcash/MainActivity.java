package com.example.instantcash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private Button iamworker,pramotebusiness;
private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iamworker= (Button) findViewById(R.id.iam_a_woker);
        pramotebusiness= (Button)findViewById(R.id.pramote_business);
mauth = FirebaseAuth.getInstance();

        iamworker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUsertoUserRegisterAtivity();
            }
        });
        pramotebusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser = mauth.getCurrentUser();
        if (currentuser!=null){

            Intent intent  = new Intent (MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

    }

    private void SendUsertoUserRegisterAtivity() {
        Intent intent =new Intent(MainActivity.this,UserRegisterActivity.class);
        startActivity(intent);
        finish();
    }
}
