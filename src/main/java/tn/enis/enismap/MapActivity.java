package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.view.Gravity;

import android.view.MotionEvent;

import android.widget.Button;

import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MapActivity extends AppCompatActivity {
    private FloatingActionButton test;
    private FloatingActionButton close;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);

        progressDialog = new ProgressDialog(MapActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progressDialog.cancel();

            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 6000);


        Intent localizeIntent = getIntent();
        final String localize = localizeIntent.getStringExtra("cle");

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("id");
        final String nameArrive = intent.getStringExtra("id2");

        String address = "file:///android_asset/index.html";
        WebView view = (WebView) this.findViewById(R.id.carte);
        view.getSettings().setJavaScriptEnabled(true);
        //  view.addJavascriptInterface(new WebAppInterface(this), "Android");
        view.loadUrl(address);
        view.setWebViewClient(new MyBrowser());
        //partial code


        final ImageView mecaLocal = (ImageView) findViewById(R.id.iv_local_icon1);
        final ImageView mecaLocal2 = (ImageView) findViewById(R.id.iv_local_icon2);
        final ImageView mecaLocal3 = (ImageView) findViewById(R.id.iv_local_icon3);
        if (name != null) {
            if (name.equals("Département Mécatronique") && (localize != null)) {
                mecaLocal2.setVisibility(View.VISIBLE);
            } else if (name.equals("Département Biologie") && (localize != null)) {
                mecaLocal.setVisibility(View.VISIBLE);
            } else if (name.equals("Département Civil") && (localize != null)) {
                mecaLocal3.setVisibility(View.VISIBLE);
            }
        } else if (nameArrive != null) {
            if (nameArrive.equals("Département Mécatronique") && (localize != null)) {
                mecaLocal2.setVisibility(View.VISIBLE);
            } else if (nameArrive.equals("Département Biologie") && (localize != null)) {
                mecaLocal.setVisibility(View.VISIBLE);
            } else if (name.equals("Département Civil") && (localize != null)) {
                mecaLocal3.setVisibility(View.VISIBLE);
            }
        }
        close = findViewById(R.id.fab_style_two);
        close.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MapActivity.this, Acceuil.class);

                MapActivity.this.startActivity(myIntent);

            }
        });

        final ImageView imgv = (ImageView) findViewById(R.id.iv_itinerary);
        test = findViewById(R.id.fab_style_one);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.iteneray_popup, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                Button btnDepart = (Button) popupView.findViewById(R.id.popup_top_button1);
                Button btnArrive = (Button) popupView.findViewById(R.id.popup_top_button2);
                String btnDepartName;
                String btnArriveName;
                if (name != null) {
                    btnDepartName = name;
                    btnDepart.setText(btnDepartName);
                    if (nameArrive != null) {
                        btnArriveName = nameArrive;
                        btnArrive.setText(btnArriveName);
                    }

                } else if (nameArrive != null) {
                    btnArriveName = nameArrive;
                    btnArrive.setText(btnArriveName);
                    if (name != null) {
                        btnDepartName = name;
                        btnDepart.setText(btnDepartName);
                    }
                }
                btnDepart.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent myIntent = new Intent(MapActivity.this, PlacesActivity.class);
                        myIntent.putExtra("key", "depart");
                        //Optional parameters
                        if (name != null)
                            myIntent.putExtra("id", name);
                        MapActivity.this.startActivity(myIntent);


                    }
                });


                btnArrive.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent myIntent = new Intent(MapActivity.this, PlacesActivity.class);
                        myIntent.putExtra("key2", "arrive"); //Optional parameters
                        if (nameArrive != null)
                            myIntent.putExtra("id2", nameArrive);
                        MapActivity.this.startActivity(myIntent);


                    }
                });

               Button itinerBut = (Button) popupView.findViewById(R.id.popup_bottom_button);


                itinerBut.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                mecaLocal3.setVisibility(View.VISIBLE);
                                mecaLocal2.setVisibility(View.VISIBLE);
                                imgv.setVisibility(View.VISIBLE);

                                popupWindow.dismiss();

                            }
                        }, 1000);

                    }
                });

              /*  if (name != null || nameArrive != null ) {

                    if (intent.getStringExtra("key") != null) {

                        btnDepartName = name;
                        btnDepart.setText(btnDepartName);

                    }
                    if (intent.getStringExtra("key2") != null) {

                        btnArriveName = name;
                        btnArrive.setText(btnArriveName);

                    }


                }*/


                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();


                        return true;
                    }
                });


            }
        });

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /*public class WebAppInterface {
        Context mContext;
        String data;

        WebAppInterface(Context ctx){
            this.mContext=ctx;
        }


        @JavascriptInterface
//this 'formData' variable is going to accept the data from webview
        public void processHTML(String formData) {
            Log.d("AWESOME_TAG", "form data: " + formData);
        }
    }*/
}
