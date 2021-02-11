package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        //setContentView(R.layout.activity_acceuil);
        /*Intent localizeIntent = getIntent();

        final String localize = localizeIntent.getStringExtra("cle");

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("id");
        intent.getStringExtra("key");
        final String id = intent.getStringExtra("id");

        intent.putExtra("key", name);
        intent.putExtra("cle", "localize");
        intent.putExtra("id", id );

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        progressBar= findViewById(R.id.progress_bar);
        textView= findViewById(R.id.text_view);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation(intent);

    }
    public void progressAnimation(Intent intent){

        ProgressBarAnimation anim =new ProgressBarAnimation(this, progressBar, textView, 0f, 100f , intent);
        anim.setDuration(2000);
        progressBar.setAnimation(anim);
    }*/
    }
}
