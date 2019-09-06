package com.example.sohag.dnatesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Relation extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1;
    Button bt1;
    String s1,s2;
    int [][]dpp=new int[100][100];
    int ln1,ln2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relation);


        bt1 = (Button) findViewById(R.id.btr1);

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
                et1 = (EditText) findViewById(R.id.etr1);
                et2 = (EditText) findViewById(R.id.etr2);

                s1=et1.getEditableText().toString();
                s2=et2.getEditableText().toString();

                ln1=s1.length();
                ln2=s2.length();

                for(int i=0; i<ln1; i++)dpp[0][i]=0;
                for(int i=0; i<ln2; i++)dpp[i][0]=0;
                for(int i=1; i<=ln1; i++)
                {
                    for(int j=1; j<=ln2; j++)
                    {
                        if(s1.charAt(i-1)==s2.charAt(j-1))
                            dpp[i][j]=dpp[i-1][j-1]+1;
                        else
                            dpp[i][j]=dpp[i][j-1]>dpp[i-1][j]?dpp[i][j-1]:dpp[i-1][j];
                    }
                }

                double mnn=ln1<ln2?ln1:ln2;
                double per=dpp[ln1][ln2]/mnn*100;

                tv1 = (TextView) findViewById(R.id.tvr1);
                if(per>=50.0) tv1.setText("Parents-Child relation or Siblings");
                else if(per>=25.0)tv1.setText("Grandparents-Grandchild");
                else if(per>=12.5)tv1.setText("Uncle-Nephiew");
                else if(per>=6.25)tv1.setText("Cousin");
                else tv1.setText("NONE");
            }
        });
    }
}
