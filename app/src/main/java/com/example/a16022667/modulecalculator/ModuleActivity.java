package com.example.a16022667.modulecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {
    EditText etName;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
        etName = (EditText) findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        Intent i = getIntent();
        etName.setText(i.getStringExtra("name"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = etName.getText().toString();
                String url = "http://10.0.2.2/third_app/updateModule.php";

                HttpRequest request = new HttpRequest(url);
                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("POST");
                request.addData("module_id", "1");
                request.addData("module",newName);
                request.execute();
                Intent ire = new Intent(ModuleActivity.this, MainActivity.class);
                startActivity(ire);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();




        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/third_app/getGrade.php");
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");


        request.execute();



        // Code for step 1 end
    }

    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){
                    Log.wtf("Response", response);
                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        JSONObject jsonObj2 = jsonArray.getJSONObject(0);
                        String module = jsonObj2.getString("module");


                        JSONObject jsonO2 = jsonArray.getJSONObject(1);


                        etName.setText(module);


                        Log.i("JSON Results: ", response);

                        //JSONObject jsonObj = new JSONObject(response);
                        //Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
            };
}
