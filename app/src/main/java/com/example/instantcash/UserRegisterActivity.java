package com.example.instantcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;

public class UserRegisterActivity extends AppCompatActivity {
private TextView DonthaveanAccount;
private EditText confirmpassword,useremail,userpassword;
private Button Regiaterbtn;
private FirebaseAuth mauth;
private ProgressDialog lodingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        mauth = FirebaseAuth.getInstance();

        DonthaveanAccount = (TextView)findViewById(R.id.dont_have_an_account);
        useremail = (EditText)findViewById(R.id.user_email);
        confirmpassword = (EditText)findViewById(R.id.user_confirm_password);
        userpassword = (EditText)findViewById(R.id.user_password);

        Regiaterbtn = (Button)findViewById(R.id.register_btn);

        DonthaveanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserRegisterActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        Regiaterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatingAccount();


            }
        });


    }

    private void CreatingAccount() {

        String cnfmpassword = confirmpassword.getText().toString();
        String email = useremail.getText().toString();
        String password = userpassword.getText().toString();

        if (TextUtils.isEmpty(cnfmpassword)){

            Toast.makeText(this, "Please confirm Your password", Toast.LENGTH_SHORT).show();
        }

      else  if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please Enter Your email", Toast.LENGTH_SHORT).show();
        }




      else  if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please Enter Your password", Toast.LENGTH_SHORT).show();
        }

        else{
mauth.createUserWithEmailAndPassword(email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){

            Intent intent = new Intent (UserRegisterActivity.this,HomeActivity.class);
            startActivity(intent);
        }
else{

    String message = task.getException().getMessage();
            Toast.makeText(UserRegisterActivity.this, "Something Went Wrong Please Try again"+message, Toast.LENGTH_SHORT).show();
        }
    }
});
        }

    }


    }



