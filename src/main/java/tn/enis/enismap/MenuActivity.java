package tn.enis.enismap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button proc= (Button) findViewById(R.id.button8);
        Button map= (Button) findViewById(R.id.button9);
        Button faq= (Button) findViewById(R.id.button10);

        proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,ProcActivity.class);
                startActivity(intent);
                finish();

            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,Acceuil.class);
                startActivity(intent);
                finish();

            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,FaqActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
