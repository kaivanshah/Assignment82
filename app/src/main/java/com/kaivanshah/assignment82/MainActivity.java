package com.kaivanshah.assignment82;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_Save, btn_Show;
    EditText  tv_Name, tv_Age, tv_Phone, tv_City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Save = (Button) (this.findViewById(R.id.btn_Save));
        btn_Show = (Button) (this.findViewById(R.id.btn_Show));

        tv_Name =(EditText) (this.findViewById(R.id.tv_Name));
        tv_Age =(EditText) (this.findViewById(R.id.tv_Age));
        tv_Phone =(EditText) (this.findViewById(R.id.tv_Phone));
        tv_City =(EditText) (this.findViewById(R.id.tv_City));
        final SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("Name", tv_Name.getText().toString());
                editor.putString("Age", tv_Age.getText().toString());
                editor.putString("Phone", tv_Phone.getText().toString());
                editor.putString("City", tv_City.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "Data is saved Successfully", Toast.LENGTH_LONG).show();
            }
        });

        btn_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder oSB = new StringBuilder();
                oSB.append("Name: " + sharedPref.getString("Name", null) + "\n");
                oSB.append("Age: " + sharedPref.getString("Age", null) + "\n");
                oSB.append("Phone: " + sharedPref.getString("Phone", null) + "\n");
                oSB.append("City: " + sharedPref.getString("City", null) + "\n");

                Toast.makeText(getApplicationContext(), oSB.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
