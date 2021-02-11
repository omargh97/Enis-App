package tn.enis.enismap;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class FaqActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }
}
