package com.example.a1atividade;

import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    TextView tv_t2;
    MediaPlayer mySound, mySound2;
    Button tocar, btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        tv_t2 = (TextView) findViewById(R.id.textView3);

        btn = (Button) findViewById(R.id.btnShow);
        RadioGroup rg_t2 = (RadioGroup) findViewById(R.id.radioGroup3);
        RadioButton rb_t2 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb2_t2 = (RadioButton) findViewById(R.id.radioButton4);
        tocar  = (Button) findViewById(R.id.button3);

        rg_t2.setOnCheckedChangeListener(selecaot2);

        mySound = MediaPlayer.create(this, R.raw.babyshark);
        mySound2 = MediaPlayer.create(this, R.raw.otaku);
        tocar.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
                    public boolean onLongClick(View v){
                        playMusic2(v);
                        return false;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(DisplayMessageActivity.this, v);
                popup.setOnMenuItemClickListener(DisplayMessageActivity.this);
                popup.inflate(R.menu.menu_example);
                popup.show();
            }
        });

    }

    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        View v = null;
        switch (item.getItemId()) {
            case R.id.tocar_baby:
                // do your code
                playMusic(v);
                return true;
            case R.id.upload_item:
                // do your code
                return true;
            case R.id.copy_item:
                // do your code
                return true;
            case R.id.print_item:
                // do your code
                return true;
            case R.id.share_item:
                // do your code
                return true;
            case R.id.bookmark_item:
                // do your code
                return true;
            default:
                return false;
        }
    }

    public void playMusic(View view){
        mySound.start();
    }
    public void playMusic2(View view){
        mySound2.start();
    }
    RadioGroup.OnCheckedChangeListener selecaot2 = new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.radioButton3:
                    tv_t2.setText(":(");
                    break;

                case R.id.radioButton4:
                    tv_t2.setText(":)");
                    break;
            }
        }
    };
}
