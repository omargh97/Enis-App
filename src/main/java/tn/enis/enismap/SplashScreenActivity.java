package tn.enis.enismap;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.*;

import static tn.enis.enismap.R.anim.rotate;

public class SplashScreenActivity extends AppCompatActivity {

    private MediaPlayer mplayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashIcon = (ImageView) findViewById(R.id.imageView);
        Animation anima = AnimationUtils.loadAnimation(SplashScreenActivity.this, rotate);
        splashIcon.startAnimation(anima);
        anima.setAnimationListener(new Animation.AnimationListener(){
            public void onAnimationStart(Animation animation){
                mplayer=MediaPlayer.create(SplashScreenActivity.this,R.raw.welcome);
                mplayer.start();
                setVolumeControlStream(AudioManager.STREAM_MUSIC);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mplayer!=null){
                    mplayer.stop();
                    mplayer.reset();
                    mplayer.release();
                }
                Intent intent=new Intent(SplashScreenActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

}
