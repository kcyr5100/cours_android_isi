package com.example.myschool_isi_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class BdActivity extends AppCompatActivity {

    private EditText txtLogin, txtPassword;
    private Button btnAdd, btnUpdate, btnDelete, btnList;
    private String login, password;
    private BdSchool bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd);
        txtLogin = findViewById(R.id.txtLoginBd);
        txtPassword = findViewById(R.id.txtPasswordBd);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnList = findViewById(R.id.btnList);

        bd = new BdSchool(this); // Creation BD, table
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                boolean b = bd.create(login, password);
                if(b){
                    Toast.makeText(BdActivity.this, "Utilisateur Crée", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BdActivity.this, "Utilisateur non Crée", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                boolean b = bd.update(login, password);
                if(b){
                    Toast.makeText(BdActivity.this, "Utilisateur modifié", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BdActivity.this, "Utilisateur non modifié", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                boolean b = bd.delete(login);
                if(b){
                    Toast.makeText(BdActivity.this, "Utilisateur supprimé", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BdActivity.this, "Utilisateur non supprimé", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                List<String> list = bd.getUsers();
                for (int i = 0; i < list.size(); i++) {
                    result = list.get(i);
                    Toast.makeText(BdActivity.this, result, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}