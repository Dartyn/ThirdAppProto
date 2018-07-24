package com.example.a16022667.modulecalculator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvname, tvgrade, tvMName;

    private ListView lvg;
    ArrayList<Grade> alg;
    GradeArrayAdapter aag;
    Button btnResult;
    Grade data;

    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvg = (ListView)findViewById(R.id.lvGrade);
        tvMName = (TextView)findViewById(R.id.textViewModuleName);




        tvMName.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent i = new Intent(getBaseContext(), ModuleActivity.class);
                                           String q = tvMName.getText().toString();
                                           i.putExtra("name",q);
                                           startActivity(i);
                                       }
                                   });
                lvg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        lvg.getSelectedItemPosition();
                        int gid = position;
                        if(gid == 13 || gid == 14){
                            t = new Intent(getBaseContext(), SecondGrade.class);

                            t.putExtra("grade_id", alg.get(position).getId());
                            t.putExtra("grade", alg.get(position).getGrade());
                            t.putExtra("grade_name", alg.get(position).getName());

                        }
                        else {
                            t = new Intent(getBaseContext(), FirstGrade.class);

                            t.putExtra("grade_id", alg.get(position).getId());
                            t.putExtra("grade", alg.get(position).getGrade());
                            t.putExtra("grade_name", alg.get(position).getName());



                        }
                        Log.d("intent is",t.toString());
                        startActivity(t);

                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.DisplayGrade) {
            Intent i = new Intent(getBaseContext(),GradeActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();

        tvname = (TextView)findViewById(R.id.textViewName);
        tvgrade = (TextView)findViewById(R.id.textViewGrade);
        alg = new ArrayList<Grade>();


        lvg = (ListView)this.findViewById(R.id.lvGrade);
        alg = new ArrayList<Grade>();
        aag = new GradeArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, alg);
        //aag = new ArrayAdapter<Grade>(this,android.R.layout.simple_list_item_2);
        lvg.setAdapter(aag);
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
                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            String gradeId = jsonObj.getString("grade_id");
                            String grade = jsonObj.getString("grade");
                            String grade_name = jsonObj.getString("grade_name");



                            String displayResults = "Id: " + gradeId + "\n\nName: "
                                    + grade + "\n";

                            Grade grd = new Grade(gradeId,grade,grade_name);
                            alg.add(grd);
                            //tvMName.setText(module);

                        }

                        JSONObject jsonO2 = jsonArray.getJSONObject(1);


                          tvMName.setText(module);


                        Log.i("JSON Results: ", response);

                        //JSONObject jsonObj = new JSONObject(response);
                        //Toast.makeText(getApplicationContext(), jsonObj.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    aag.notifyDataSetChanged();
                }
            };
}
