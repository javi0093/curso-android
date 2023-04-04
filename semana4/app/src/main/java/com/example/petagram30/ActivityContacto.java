package com.example.petagram30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.petagram30.config_de_javaMail.SendMail;

public class ActivityContacto extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessaje;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextEmail = (EditText) findViewById(R.id.etCorreo);
        editTextSubject = (EditText) findViewById(R.id.etNombre);
        editTextMessaje = (EditText) findViewById(R.id.etMensaje);
        buttonEnviar = (Button) findViewById(R.id.btnEnviarComentario);
        buttonEnviar.setOnClickListener(this);

    }

    private void sendEmail(){
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessaje.getText().toString().trim();

        SendMail sm = new SendMail(this, email, subject, message);
        sm.execute();
    }

    @Override
    public void onClick(View view) {
        sendEmail();
    }
}