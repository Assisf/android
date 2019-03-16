package com.example.a1atividade;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    Button bt1;
    Toolbar myToolbar;
    private RadioGroup radioGroup;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    String str[]={"Gato","Cachorro","Leão","Tigre","Arara",
            "Aranha","Cobra","Baleia","Boto","Gavião","Flamingo"};

    public static final String EXTRA_MESSAGE = "com.example.1Atividade.MESSAGE";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //barra de app
        //myToolbar = (Toolbar) findViewById(R.id.toolbar);


        bt1 = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.textView);

        AutoCompleteTextView acObjText =
                (AutoCompleteTextView) findViewById(R.id.acTexto);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, str);
        acObjText.setAdapter(adapter);
       // RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);

      //  RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);





        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tv.setText("Toggle ON");
                    // The toggle is enabled
                } else {
                    tv.setText("Toggle OFF");
                    // The toggle is disabled
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void openSecondWidow(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }



}