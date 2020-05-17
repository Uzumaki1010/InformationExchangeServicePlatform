package com.example.informationexchangeserviceplatform.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.informationexchangeserviceplatform.R;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonFinishRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonFinishRegister=this.findViewById(R.id.button_finishRegister);
        buttonFinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                RegisterActivity.this.finish();
            }
        });
    }
}
