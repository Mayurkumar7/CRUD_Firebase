package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {

    private TextInputLayout userNameEdt , pwdEdt;
    private Button loginBtn;
    private TextView registerTV;
    private ProgressBar loadingPb;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEdt = findViewById(R.id.idEdtUserName);
        pwdEdt= findViewById(R.id.idEdtPassword);
        loginBtn= findViewById(R.id.idBtnLogin);
        registerTV = findViewById(R.id.idTvRegister);
        loadingPb= findViewById(R.id.idPbLoading);
        mAuth = FirebaseAuth.getInstance();

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPb.setVisibility(View.VISIBLE);
                String userName = userNameEdt.getEditText().toString();
                String pwd = pwdEdt.getEditText().toString();
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(pwd)){
                    Toast.makeText(Login_Activity.this, "please enter your credential", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    mAuth.signInWithEmailAndPassword(userName , pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){
                               loadingPb.setVisibility(View.GONE);
                               Toast.makeText(Login_Activity.this, "login Successful..", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(Login_Activity.this, MainActivity.class));
                               finish();
                           }else {
                               loadingPb.setVisibility(View.GONE);
                               Toast.makeText(Login_Activity.this, "fail login..", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            startActivity(new Intent(Login_Activity.this, MainActivity.class));
            this.finish();

        }
    }
}