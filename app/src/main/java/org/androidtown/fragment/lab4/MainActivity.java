package org.androidtown.fragment.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    RadioButton male;
    RadioButton female;
    CheckBox SMS;
    CheckBox Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        male=(RadioButton)findViewById(R.id.Radio1);
        female=(RadioButton)findViewById(R.id.Radio2);
        SMS=(CheckBox)findViewById(R.id.chec1);
        Email=(CheckBox)findViewById(R.id.chec2);

        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {



                String name=editText.getText().toString();
                String gender;
                String msg="";

                if(male.isChecked())
                    gender="남";
                else
                    gender="여";


                if(SMS.isChecked())
                    msg+="SMS ";
                if(Email.isChecked())
                    msg+=" Email ";




                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                Bundle bundle=new Bundle();

                bundle.putString("name",name);
                bundle.putString("gender",gender);
                bundle.putString("msg",msg);


                intent.putExtras(bundle);

                startActivity(intent);


/*
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("gender",gender);
                intent.putExtra("msg",msg);

                startActivity(intent);/*/

            }

        });
    }
}