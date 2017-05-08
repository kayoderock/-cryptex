package com.sureife.cryptex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class NewActivity extends AppCompatActivity {
    EditText titleEditText;
    EditText contentEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        bindViews();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();

                File file = new File(NewActivity.this.getFilesDir(), title);

            }
        });
    }

    void bindViews(){
        titleEditText = (EditText)findViewById(R.id.et_title);
        contentEditText = (EditText)findViewById(R.id.et_content);
    }
}
