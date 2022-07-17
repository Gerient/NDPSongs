package sg.edu.rp.c346.id20014027.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    Button btn5Stars;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btn5Stars = findViewById(R.id.button5Stars);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<>(ShowList.this, android.R.layout.simple_expandable_list_item_1, al);
        lv.setAdapter(aa);

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowList.this);

                ArrayList<Song> data = dbh.getAllSongs();
                dbh.close();

                String txt = "";
                for(int i = 0; i < data.size(); i++){
                    Log.d("Database Content", i + ". "+data.get(i));
                    txt += (i+1) + ". " + data.get(i) + "\n";
                }


            }
        });
    }
}