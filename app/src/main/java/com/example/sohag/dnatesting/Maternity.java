package com.example.sohag.dnatesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Maternity extends AppCompatActivity {

    Button bt1,bt2;
    EditText et1,et2,et3;

    TextView tv1;
    int n=1;
    /*-------------*/
    String s1,s2,child;
    String sm[] = new String[20];
    int ln1,ln2,flag=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maternity);

        bt1 = (Button) findViewById(R.id.btp1);
        bt2 = (Button) findViewById(R.id.btp2);

        et1 = (EditText) findViewById(R.id.etp1);
        et2 = (EditText) findViewById(R.id.etp2);
        et3 = (EditText) findViewById(R.id.etp3);

        tv1 = (TextView) findViewById(R.id.tvp1);

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                sm[n]=et3.getEditableText().toString();
                et3.setText("");
                n=n+1;
                et3.setHint("DNA of Woman_"+n);
            }
        });


        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                child=et1.getEditableText().toString();
                s1=et2.getEditableText().toString();
                sm[n]=et3.getEditableText().toString();

                et1.setText("");
                et2.setText("");
                et3.setText("");
                et1.setHint("Child's DNA");
                et2.setHint("Father's DNA");

                /*----------------------------*/

                flag=0;
                if(child.equals(""))flag=1;
                if(flag==0) {
                    for (int i = 1; i <= n; i++) {
                        s2 = sm[i];
                        if (child.equals(lcs(child, lcs(s1, s2)))) {
                            flag = 1;
                            tv1.setText("Mother is woman_" + i);
                            break;
                        }
                    }
                }
                if(flag==0)tv1.setText("Mother is missing here");

                /*----------------------------------*/
                n=1;
                et3.setHint("DNA of Woman_"+n);
            }
        });
    }


    public String lcs(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] arr = new int[l1 + 1][l2 + 1];
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }


        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2)
        {
            if (str1.charAt(i) == str2.charAt(j))
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) i++;
            else j++;
        }
        return sb.toString();
    }
}
