package sg.edu.rp.c346.id20014027.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvSinger, tvYear;
    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShow;
    RadioGroup rgStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvSongTitle);
        tvSinger = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvStars);
        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShowList);
        rgStars = findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int starNo = 0;
                int checkRBId = rgStars.getCheckedRadioButtonId();

                if(checkRBId == R.id.rb1){
                    starNo = 1;
                }
                else if (checkRBId == R.id.rb2){
                    starNo = 2;
                }
                else if(checkRBId == R.id.rb3){
                    starNo = 3;
                }
                else if(checkRBId == R.id.rb4){
                    starNo = 4;
                }
                else if(checkRBId == R.id.rb5){
                    starNo = 5;
                }

                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int stars = starNo;

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(title, singer, year, stars);

                if(inserted_id != 1){
                    Toast.makeText(MainActivity.this, "Insert Successful",
                            Toast.LENGTH_SHORT).show();
                }
                etTitle.setText("");
                etSinger.setText("");
                etYear.setText("");
                rgStars.clearCheck();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowList.class);
                startActivity(i);
            }
        });

    }
}