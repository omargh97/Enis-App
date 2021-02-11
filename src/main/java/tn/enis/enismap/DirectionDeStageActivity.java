package tn.enis.enismap;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
public class DirectionDeStageActivity extends  AppCompatActivity{

    Button premiere,deuxieme,troisieme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction_de_stage);
        premiere= (Button) findViewById(R.id.prem);
        deuxieme= (Button) findViewById(R.id.deux);
        troisieme= (Button) findViewById(R.id.trois);

        premiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DirectionDeStageActivity.this,PremiereActivity.class);
                startActivity(intent);
                finish();

            }
        });

        deuxieme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DirectionDeStageActivity.this,PremiereActivity.class);
                startActivity(intent);
                finish();

            }
        });

        troisieme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DirectionDeStageActivity.this,PremiereActivity.class);
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
