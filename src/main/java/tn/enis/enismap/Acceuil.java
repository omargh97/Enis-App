package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import tn.enis.enismap.adapters.AutoCompletePlacesAdapter;
import tn.enis.enismap.adapters.PlaceItem;

public class Acceuil extends AppCompatActivity {
    private List<PlaceItem>  placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        ImageView imageView_img =  (ImageView) findViewById(R.id.imageEnis);
        TextView places_tv =  (TextView) findViewById(R.id.tv_place2);

        imageView_img.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){

                Intent intent = new Intent (Acceuil.this, MapActivity.class);
                startActivity(intent);
            }
        });

        fillCountryList();

        final AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompletePlacesAdapter adapter = new AutoCompletePlacesAdapter(this , placeList);


        editText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* Toast.makeText(getApplicationContext(), editText.getEditableText()+ "This is my Toast message!",
                        Toast.LENGTH_LONG).show();*/
                Intent myIntent = new Intent(view.getContext(), PlaceDetailActivity.class);
                myIntent.putExtra("key", editText.getEditableText().toString());
                startActivity(myIntent);
            }
        });
        editText.setAdapter(adapter);

      places_tv.setOnClickListener (new TextView.OnClickListener() {
            public void onClick (View v){
                Intent myIntent = new Intent (Acceuil.this, PlacesActivity.class);
                myIntent.putExtra("key", "all"); //Optional parameters
                Acceuil.this.startActivity(myIntent);

            }
        });



    }


    private void fillCountryList(){
        placeList = new ArrayList<>();
        placeList.add(new PlaceItem("Département Informatique",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Civil",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Electrique",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Mécatronique",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Biologie",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Géologie",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Département Matériaux",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Ecole doctorale",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Administration",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Scolarité",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Laboratoires",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Atelier",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Amphis",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Amphi rond",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Les Salles S",R.drawable.ic_logo));
        placeList.add(new PlaceItem("Terrain",R.drawable.ic_logo));
    }
    //https://www.w3schools.com/colors/colors_picker.asp
}
