package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_place_detail);
        setContentView(R.layout.activity_place_detail);
        Intent intent = getIntent();
        final TextView localizeTv = findViewById(R.id.tv_place2);
        final String name = intent.getStringExtra("key");
        final String nametxt;
        final List<String> nameList = new ArrayList<String>();
        final List<String> mailList = new ArrayList<String>();
        final List<String> telList = new ArrayList<String>();
        final List<String> funList = new ArrayList<String>();
        final TextView title = findViewById(R.id.title);
        final TextView title1 = findViewById(R.id.subTitle);
        final TextView phoneNb = findViewById(R.id.phoneNb);
        final TextView mail = findViewById(R.id.mailTv);
        final TextView funName = findViewById(R.id.funName);
        final TextView title2 = findViewById(R.id.subTitle2);
        final TextView phoneNb2 = findViewById(R.id.phoneNb2);
        final TextView mailTv2 = findViewById(R.id.mailTv2);
        final TextView funName2 = findViewById(R.id.funName2);
        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference myRef = database.getReference().child("places").child("civil");

        // DatabaseReference zonesRef = FirebaseDatabase.getInstance().getReference("places");
        // DatabaseReference zone1Ref = zonesRef.child("civil");
        // DatabaseReference myRef = zone1Ref.child("civil");
        title.setText(name);
        if (name.equals("Département Informatique")) {
            nametxt = "computerScience";
        } else if (name.equals("Département Civil")) {
            nametxt = "civil";
        } else if (name.equals("Département Electrique")) {
            nametxt = "electrical";
        } else if (name.equals("Les Salles S")) {
            nametxt = "atelier";
        } else if (name.equals("Amphis")) {
            nametxt = "computerScience";
        } else if (name.equals("Scolarité")) {
            nametxt = "scolarity";
        } else if (name.equals("Administration")) {
            nametxt = "administration";
        } else if (name.equals("Laboratoires")) {
            nametxt = "lab";
        } else if (name.equals("Département Mécatronique")) {
            nametxt = "mechanical";
        } else if (name.equals("Ecole doctorale")) {
            nametxt = "computerScience";
        } else if (name.equals("Département Matériaux")) {
            nametxt = "material";
        } else if (name.equals("Terrain")) {
            nametxt = "atelier";
        } else if (name.equals("Département Géologie")) {
            nametxt = "geology";
        } else {
            nametxt = "atelier";
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference().child("Places").child(nametxt);
        // Read from the database
        //  String key = database.getReference("civil").push().getKey();
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                int i = 0;
                for (DataSnapshot eventSnapshot : dataSnapshot.getChildren()) { //

                    // String userName2 = eventSnapshot.child("name").getValue(String.class);
                    /*String userNbPhone2 = eventSnapshot.child("tel").getValue(String.class);
                    String userMail2 = eventSnapshot.child("mail").getValue(String.class);
                    String userFun2 = eventSnapshot.child("fonction").getValue(String.class);*/

                    nameList.add(eventSnapshot.child("name").getValue(String.class));

                    mailList.add(eventSnapshot.child("email").getValue(String.class));

                    telList.add(eventSnapshot.child("tel").getValue(String.class));

                    funList.add(eventSnapshot.child("fonction").getValue(String.class));
                    i++;
                    // title2.setText(userName2);
                    /* for (DataSnapshot childEventSnapshot : eventSnapshot.getChildren()) {
                        Item_Get_List newPost = childEventSnapshot.child("name").getValue(Item_Get_List.class);
                        System.out.println("GetChildren: "+childEventSnapshot.child("name")); System.out.println("details: "+childEventSnapshot.child("name").getValue());
                    }*/
                }
                String userName = nameList.get(0);
                String userName2 = nameList.get(1);
                String userNbPhone = telList.get(0);
                String userNbPhone2 = telList.get(1);
                String userMail = mailList.get(0);
                String userMail2 = mailList.get(1);
                String userFun = funList.get(0);
                String userFun2 = funList.get(1);

                title1.setText(userName);
                title2.setText(userName2);
                phoneNb.setText(userNbPhone);
                phoneNb2.setText(userNbPhone2);
                mail.setText(userMail);
                mailTv2.setText(userMail2);
                funName.setText(userFun);
                funName2.setText(userFun2);



                    /*Contact detail = dataSnapshot.getValue(Contact.class);

                    String name = detail.getUserName();

                    titletv.setText(name);*/

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
     localizeTv.setOnClickListener (new TextView.OnClickListener() {
            public void onClick (View v){
                Intent myIntent = new Intent (PlaceDetailActivity.this, MapActivity.class);
                myIntent.putExtra("cle", "localize"); //Optional parameters
              PlaceDetailActivity.this.startActivity(myIntent);

            }
        });

    }
}
