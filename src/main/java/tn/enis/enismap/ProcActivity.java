package tn.enis.enismap;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class ProcActivity extends AppCompatActivity{

    Button direction_de_stage,direction_des_etudes,ecole_doctoral,secretariat_general,departement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proc);
        direction_de_stage = (Button) findViewById(R.id.dds);
        direction_des_etudes = (Button) findViewById(R.id.dde);
        ecole_doctoral = (Button) findViewById(R.id.ed);
        secretariat_general = (Button) findViewById(R.id.sg);
        departement = (Button) findViewById(R.id.dep);


        direction_de_stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcActivity.this, DirectionDeStageActivity.class);
                startActivity(intent);
                finish();

            }
        });

        direction_des_etudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcActivity.this, DirectionDeStageActivity.class);
                startActivity(intent);
                finish();

            }
        });
        ecole_doctoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcActivity.this, DirectionDeStageActivity.class);
                startActivity(intent);
                finish();

            }
        });
        secretariat_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcActivity.this, DirectionDeStageActivity.class);
                startActivity(intent);
                finish();

            }
        });
        departement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcActivity.this, DirectionDeStageActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
