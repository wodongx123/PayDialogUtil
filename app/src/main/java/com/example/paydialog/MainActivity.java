package com.example.paydialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.paydialogutil.PayDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PayDialog payDialog = new PayDialog(MainActivity.this);
                payDialog.setText("支付", "请支付10元", "忘记密码", "忘记密码", "忘记密码")
                        .setListener(new PayDialog.DialogListener() {
                            @Override
                            public void fillContent(String content) {
                                if (content.length() == 6){
                                    payDialog.dismiss();
                                    Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void leftBtn() {
                                Toast.makeText(MainActivity.this, "left button", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void centerBtn() {
                                Toast.makeText(MainActivity.this, "center button", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void rightBtn() {
                                Toast.makeText(MainActivity.this, "right button", Toast.LENGTH_SHORT).show();
                            }
                        });
                payDialog.show();
            }
        });

    }
}
