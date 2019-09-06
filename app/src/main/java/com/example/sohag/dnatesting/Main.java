package com.example.sohag.dnatesting;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send1(View view){
        Intent ntnt = new Intent(this,Paterinty.class);
        startActivity(ntnt);
    }

    public void send2(View view){
        Intent ntnt = new Intent(this,Maternity.class);
        startActivity(ntnt);
    }

    public void send3(View view){
        Intent ntnt = new Intent(this,Parents.class);
        startActivity(ntnt);
    }

    public void send4(View view){
        Intent ntnt = new Intent(this,Relation.class);
        startActivity(ntnt);
    }


}
