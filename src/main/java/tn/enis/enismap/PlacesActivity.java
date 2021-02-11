package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import tn.enis.enismap.adapters.PlacesAdapter;


public class PlacesActivity extends AppCompatActivity implements PlacesAdapter.ItemClickListener {
    PlacesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itenerary_places);

        TextView textView = (TextView) findViewById(R.id.tv_name);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("key");
        final String nameArrive = intent.getStringExtra("key2");
        if (nameArrive != null) {
            textView.setText("Point d'arrivée");
        } else if (name.equals("all")) {
            textView.setText("Tous les lieux");
        }
        // data to populate the RecyclerView with
        ArrayList<String> placeNames = new ArrayList<>();

        placeNames.add("Département Informatique");
        placeNames.add("Département Civil");
        placeNames.add("Département Electrique");
        placeNames.add("Département Mécatronique");
        placeNames.add("Département Biologie");
        placeNames.add("Département Géologie");
        placeNames.add("Département Matériaux");
        placeNames.add("Ecole doctorale");
        placeNames.add("Administration");
        placeNames.add("Scolarité");
        placeNames.add("Laboratoires");
        placeNames.add("Atelier");
        placeNames.add("Amphis");
        placeNames.add("Amphi rond");
        placeNames.add("Les Salles S");
        placeNames.add("Terrain");


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvPlaces);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlacesAdapter(this, placeNames);
        adapter.setClickListener((PlacesAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);
    }


    public void onItemClick(View view, int position) {

        Intent myIntent = new Intent(PlacesActivity.this, MapActivity.class);

        Intent intent = getIntent();

        final String name = intent.getStringExtra("key");
        final String nameArrive = intent.getStringExtra("key2");


        final String dep  = intent.getStringExtra("id");
        final String arr = intent.getStringExtra("id2");



        if( dep != null){

            myIntent.putExtra("id", dep);
        }
        else if ( arr != null ){

            myIntent.putExtra("id2", arr);
        }



        if(name != null){
            myIntent.putExtra("key", name);
            myIntent.putExtra("id", adapter.getItem(position));
        }
        else if (nameArrive != null ){
            myIntent.putExtra("key2", nameArrive);
            myIntent.putExtra("id2", adapter.getItem(position));
        }



        myIntent.putExtra("cle", "localize");


        //Optional parameters
        PlacesActivity.this.startActivity(myIntent);



        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}