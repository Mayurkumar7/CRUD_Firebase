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

import java.util.Objects;

public class Register_Activity extends AppCompatActivity {

    private TextInputLayout userNameEdt , pwdEdt , cnfPwdEdt;
    private Button registerBtn;
    private ProgressBar pbLoading;
    private FirebaseAuth mAuth;
    private TextView loginTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameEdt = findViewById(R.id.idEdtUserName);
        pwdEdt = findViewById(R.id.idEdtPassword);
        cnfPwdEdt = findViewById(R.id.idEdtConformPassword);
        registerBtn = findViewById(R.id.idBtnRegister);
        pbLoading = findViewById(R.id.idPbLoading);
        mAuth = FirebaseAuth.getInstance();
        loginTV = findViewById(R.id.idTvLogin);
        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_Activity.this, Login_Activity.class));

            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbLoading.setVisibility(View.VISIBLE);
                String userName = userNameEdt.getEditText().toString();
                String pwd = pwdEdt.getEditText().toString();
                String cnPwd = cnfPwdEdt.getEditText().toString();

                if (!pwd.equals(cnPwd)){
                    Toast.makeText(Register_Activity.this, "please check both password", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(userName) && TextUtils.isEmpty(pwd) && TextUtils.isEmpty(cnPwd)){
                    Toast.makeText(Register_Activity.this, "please enter all credential", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(userName, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                pbLoading.setVisibility(View.GONE);
                                Toast.makeText(Register_Activity.this, "user Registered", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register_Activity.this, Login_Activity.class));
                                finish();

                            }else {
                                pbLoading.setVisibility(View.GONE);
                                Toast.makeText(Register_Activity.this, "fail to register user", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }



            }
        });

    }
}