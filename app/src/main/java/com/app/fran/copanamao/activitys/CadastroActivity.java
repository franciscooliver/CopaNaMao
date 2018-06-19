package com.app.fran.copanamao.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.fran.copanamao.R;

public class CadastroActivity extends AppCompatActivity {
    private EditText edtNomeCds;
    private EditText edtEmailCds;
    private EditText edtSenhaCds;
    private TextView txtPossuiConta;
    private Button btnCds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCds = findViewById(R.id.btnCds);
        edtNomeCds = findViewById(R.id.edtNomeCds);
        edtEmailCds = findViewById(R.id.edtEmailCds);
        edtSenhaCds = findViewById(R.id.edtSenhaCds);
        txtPossuiConta = findViewById(R.id.txtPossuiConta);

    }

    public void cadastraUsuario(View view){}

    public void telaLogin(View view){
        Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity( intent );
        finish();
    }

}
