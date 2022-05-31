package com.example.clinic_kursach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button registerBtn = findViewById(R.id.btnSignUp);
        final TextView loginNowBtn = findViewById(R.id.login);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToLogin();
            }
        });
    }

    private void registerUser() {
        final EditText polis = findViewById(R.id.polis);
        final EditText surname = findViewById(R.id.surname);
        final EditText name = findViewById(R.id.name);
        final EditText fromfather = findViewById(R.id.fromfather);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        final EditText repassword = findViewById(R.id.repassword);

        String pol = polis.getText().toString();
        String snam = surname.getText().toString();
        String nam = name.getText().toString();
        String ffath = fromfather.getText().toString();
        String emailTxt = email.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();

        if (pol.isEmpty() || snam.isEmpty() || nam.isEmpty() || emailTxt.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Заполните все поля", Toast.LENGTH_LONG).show();
        }
        else {
            if (!pass.equals(repass)) {
                Toast.makeText(RegisterActivity.this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            }
            else {
                mAuth.createUserWithEmailAndPassword(emailTxt, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(pol, snam, nam, ffath, emailTxt);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    showMainActivity();
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Регистрация не прошла", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }
    }

    private void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void switchToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}