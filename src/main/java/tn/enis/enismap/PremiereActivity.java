package tn.enis.enismap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PremiereActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premiere);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
