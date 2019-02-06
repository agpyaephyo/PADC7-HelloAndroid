package com.padcmyanmar.padc7_helloandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TestActivity extends AppCompatActivity {

    private static final String IE_TEXT_TO_DISPLAY = "IE_TEXT_TO_DISPLAY";
    public static final String IE_RETURN_DATA = "IE_RETURN_DATA";

    public static Intent newIntent(Context context, String textToDisplay) {
        Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra(IE_TEXT_TO_DISPLAY, textToDisplay);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TextView tvMyGreetings = findViewById(R.id.tv_my_greetings);
        tvMyGreetings.setText("Setting Text From Java");

        final ImageView ivMyGreetings = findViewById(R.id.iv_my_greetings);

        Button btnChineseGreetings = findViewById(R.id.btn_chinese_greetings);
        btnChineseGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivMyGreetings.setImageResource(R.drawable.greetings_06);
            }
        });


        final int[] greetingImages = {R.drawable.greetings_01, R.drawable.greetings_02,
                R.drawable.greetings_03, R.drawable.greetings_04,
                R.drawable.greetings_05, R.drawable.greetings_06};
        Button btnRandomGreetings = findViewById(R.id.btn_random_greetings);
        btnRandomGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomSeed = new Random();
                int randomIndex = randomSeed.nextInt(greetingImages.length);
                ivMyGreetings.setImageResource(greetingImages[randomIndex]);

            }
        });

        ImageButton btnSayHi = findViewById(R.id.btn_say_hi);
        final EditText etSayHi = findViewById(R.id.et_my_greetings);
        btnSayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar sb = Snackbar.make(view,
                        "Say Hi : " + etSayHi.getText(),
                        Snackbar.LENGTH_INDEFINITE);
                sb.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sb.dismiss();
                    }
                });
                sb.show();
            }
        });


        final CheckBox cbBanana = findViewById(R.id.cb_banana);
        final CheckBox cbApple = findViewById(R.id.cb_apple);
        final CheckBox cbOrange = findViewById(R.id.cb_orange);

        TextView btnCheckFruit = findViewById(R.id.btn_check_fruits);
        btnCheckFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pickedFruits = cbBanana.isChecked() ? getString(R.string.fruit_banana) : "";
                pickedFruits += cbApple.isChecked() ? ", " + getString(R.string.fruit_apple) : "";
                pickedFruits += cbOrange.isChecked() ? ", " + getString(R.string.fruit_orange) : "";

                AlertDialog alertDialog = new AlertDialog.Builder(TestActivity.this).create();
                alertDialog.setTitle(getString(R.string.alert_title_picked_fruits));
                alertDialog.setMessage(getString(R.string.format_msg_picked_fruits, pickedFruits));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        RadioButton rbGentleman = findViewById(R.id.rb_gentleman);
        rbGentleman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Gentleman is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioButton rbLady = findViewById(R.id.rb_lady);
        rbLady.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Lady is checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        String textToDisplay = getIntent().getStringExtra(IE_TEXT_TO_DISPLAY);

        TextView tvTextToDisplay = findViewById(R.id.tv_text_to_display);
        tvTextToDisplay.setText(textToDisplay);

        Button btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(IE_RETURN_DATA, "Data from Text Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
