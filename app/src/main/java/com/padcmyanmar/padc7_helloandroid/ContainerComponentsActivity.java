package com.padcmyanmar.padc7_helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ContainerComponentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_components);

        Button btnStartUIComponent1 = findViewById(R.id.btn_start_ui_component_1);
        btnStartUIComponent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
            }
        });

        Button btnSelectUserImage = findViewById(R.id.btn_select_image);
        btnSelectUserImage.setOnClickListener(new View.OnClickListener() {
            static final int REQUEST_IMAGE_GET = 1;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE_GET);
            }
        });
    }
}
