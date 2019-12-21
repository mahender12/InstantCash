package com.example.instantcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLoginActivity extends AppCompatActivity {
private EditText loginemail,loginpassword;
private Button loginbtn;
private TextView forgotpassword,newaccount;
private CheckBox checkBox;
FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mauth = FirebaseAuth.getInstance();

        loginemail = (EditText)findViewById(R.id.login_email);
        loginpassword =(EditText)findViewById(R.id.login_password);
        checkBox = (CheckBox)findViewById(R.id.login_check_box);
        forgotpassword = (TextView)findViewById(R.id.forgot_password);
        newaccount = (TextView)findViewById(R.id.dont_have_an_account);
        loginbtn = (Button)findViewById(R.id.login_btn);


 newaccount.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent intent = new Intent(UserLoginActivity.this,UserRegisterActivity.class);
         startActivity(intent);
     }
 });
forgotpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
loginbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        AllowingTOUserAccount();
                }
            });


        }

    private void AllowingTOUserAccount() {

        final String email = loginemail.getText().toString();
        String password = loginpassword.getText().toString();
        if (TextUtils.isEmpty(email)) {

            Toast.makeText(UserLoginActivity.this, "Please Enter Your email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)) {

            Toast.makeText(UserLoginActivity.this, "Please Enter Your password", Toast.LENGTH_SHORT).show();
        }
mauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){

            Intent intent = new Intent (UserLoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        else{
            String message  = task.getException().getMessage();
            Toast.makeText(UserLoginActivity.this, "something went wrong "+message, Toast.LENGTH_SHORT).show();
        }
    }
});
    }}