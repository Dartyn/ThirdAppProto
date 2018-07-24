package com.example.a16022667.modulecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONObject;

public class FirstGrade extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rba, rbb, rbc, rbd, rbf, rbx, rbloa;
    Button btnSubmit;
    Grade data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_grade);
        Intent i = getIntent();
        final String id = i.getStringExtra("grade_id");
        String name = i.getStringExtra("grade_name");
        String grade = i.getStringExtra("grade");
        btnSubmit = (Button)findViewById(R.id.btnSubmit);


        rg = (RadioGroup)findViewById(R.id.rg);
        rba = (RadioButton)findViewById(R.id.rbA);
        rbb = (RadioButton)findViewById(R.id.rbB);
        rbc = (RadioButton)findViewById(R.id.rbC);
        rbd = (RadioButton)findViewById(R.id.rbD);
        rbf = (RadioButton)findViewById(R.id.rbF);
        rbx = (RadioButton)findViewById(R.id.rbX);
        rbloa = (RadioButton)findViewById(R.id.rbLOA);


        rba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "A";
            }
        });
        rbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "B";
            }
        });
        rbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "C";
            }
        });
        rbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "D";
            }
        });
        rbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "F";
            }
        });
        rbx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "X";
            }
        });
        rbloa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gradeChange = "LOA";
            }
        });




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String value = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                //DBHelper dbh = new DBHelper(FirstGrade.this);
                String url = "http://10.0.2.2/third_app/updateGradeByID.php";
                //dbh.updateGrade("grade");
                //Intent i1 = getIntent();
                HttpRequest request = new HttpRequest(url);

                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("POST");
                request.addData("grade_id", id);
                request.addData("grade", value);
                request.execute();

                //data = (Grade) i1.getSerializableExtra("");

                Intent ig1 = new Intent(getBaseContext(), MainActivity.class);

                startActivity(ig1);

            }
        });


    }
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        Log.i("JSON Results: ", response);

                        JSONObject jsonObj = new JSONObject(response);
                        Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
            };
}
