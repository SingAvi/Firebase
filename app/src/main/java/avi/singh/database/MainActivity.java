package avi.singh.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

        EditText Name;
        EditText Category;
        Spinner State;
        EditText Latitude;
        EditText Longitude;
        EditText Number;
        EditText About;
        EditText Area;
        EditText Bttv;
        Button Save;

        String Cat;
        int a =0;

        DatabaseReference tree;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       tree= FirebaseDatabase.getInstance().getReference();


        Name= ( EditText)findViewById(R.id.name);
        Number= ( EditText)findViewById(R.id.num);
        Category= ( EditText)findViewById(R.id.category);
        Latitude= ( EditText)findViewById(R.id.lat);
        Longitude= ( EditText)findViewById(R.id.longi);
        About= ( EditText)findViewById(R.id.about);
        Area= ( EditText)findViewById(R.id.area);
        Bttv= ( EditText)findViewById(R.id.time);
        Save=(Button)findViewById(R.id.done);
        State=(Spinner)findViewById(R.id.state);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a==0)
                {
                    Toast.makeText(MainActivity.this, "Please Recheck the Details", Toast.LENGTH_SHORT).show();
                    a=1;
                }

                else {
                    Integer Count;
                    String a;
                    Cat = Category.getText().toString();
                    a=Number.getText().toString();
                    Count=Integer.parseInt(a);
                    DatabaseReference root = tree.child("info");
                    DatabaseReference cate = root.child(Cat);
                    DatabaseReference count = cate.child(String.valueOf(Count));


                    Map<String, Object> map = new HashMap<>();
                    map.put("name", Name.getText().toString());
                    map.put("category",Category.getText().toString());
                    map.put("lat",Latitude.getText().toString());
                    map.put("longi",Longitude.getText().toString());
                    map.put("about",About.getText().toString());
                    map.put("area",Area.getText().toString());
                    map.put("time",Bttv.getText().toString());
                    map.put("state",State.getSelectedItem().toString());

                    if (Cat.equals("ws")) {
                        count.updateChildren(map);
                        Name.setText("");
                        Category.setText("");
                        Latitude.setText("");
                        Longitude.setText("");
                        About.setText("");
                        Bttv.setText("");
                        Area.setText("");
                    }
                    else if (Cat.equals("np")) {
                        count.updateChildren(map);
                        Name.setText("");
                        Category.setText("");
                        Latitude.setText("");
                        Longitude.setText("");
                        About.setText("");
                        Bttv.setText("");
                        Area.setText("");
                    }
                    else if (Cat.equals("bs")) {
                        count.updateChildren(map);
                        Name.setText("");
                        Category.setText("");
                        Latitude.setText("");
                        Longitude.setText("");
                        About.setText("");
                        Bttv.setText("");
                        Area.setText("");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please recheck CATEGORY (ws/bs/np)", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
