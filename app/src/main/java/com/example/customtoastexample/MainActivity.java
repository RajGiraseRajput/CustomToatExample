package com.example.customtoastexample;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // default Toast
        // Toast.makeText(this, "This is first Toast", Toast.LENGTH_SHORT).show();


        btn_Toast = findViewById(R.id.btn_Toast);
        btn_Toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Custom Toast
                Toast toast = new Toast(MainActivity.this);
                View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));
                toast.setView(view);

                TextView tv_msg = view.findViewById(R.id.tv_msg);
                tv_msg.setText("Message sent Successfully");

                toast.setDuration(Toast.LENGTH_SHORT);

//                toast.setGravity(Gravity.TOP|Gravity.END,0,0);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });


    }
}