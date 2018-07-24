package com.example.a16022667.modulecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GradeActivity extends AppCompatActivity {

    Button btn;
    TextView tvCag, tvexam, tvTotal;
    Grade data;

    Double cag,exg,tg;
    private static DecimalFormat df2 = new DecimalFormat("#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);




        // Inflate the layout for this fragment
        tvCag = (TextView) findViewById(R.id.tvCAG);
        tvexam = (TextView) findViewById(R.id.tvExam);
        tvTotal = (TextView) findViewById(R.id.tvGrade);
        //btn = (Button) findViewById(R.id.button);

        //System.out.print(lgraded);






    }
    @Override
    protected void onResume() {
        super.onResume();
/*
            tvname = (TextView)findViewById(R.id.textViewName);
            tvgrade = (TextView)findViewById(R.id.textViewGrade);

            lvg = (ListView)this.findViewById(R.id.lvGrade);
            alg = new ArrayList<Grade>();
            aag = new GradeArrayAdapter(this, R.layout.row, alg);
            lvg.setAdapter(aag); */

        // Code for step 1 start
        HttpRequest request = new HttpRequest
                ("http://10.0.2.2/third_app/getGrade.php");
        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        //HttpRequest request2 = new HttpRequest("http://localhost/third_app/getName.php");
        //request2.setOnHttpResponseListener(mHttpResponseListener);
        //request2.setMethod("POST");
        request.execute();
        //request2.execute();
        // Code for step 1 end
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_return, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.Return) {
            Intent i = new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        double cagrade = 0.0;
                        double sagrade = 0.0;
                        double ttgrade = 0.0;


                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            String gradeId = jsonObj.getString("grade_id");
                            String grade = jsonObj.getString("grade");
                            String grade_name = jsonObj.getString("grade_name");
                            String module = jsonObj.getString("module");
                            Log.d("Grade ID", gradeId);
                            Log.d("Grade", grade);


                            if(gradeId.equals("1")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("2")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("3")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("4")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("5")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("5")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("7")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("8")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("9")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("10")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("11")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("12")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("13")) {
                                if (grade.equals("A")) {
                                    //cagrade += 0.30769230769230769230769230769230769230769231;
                                    cagrade += 0.09;
                                    ttgrade += 0.09;
                                } else if (grade.equals("B")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 3);
                                    cagrade += 0.07;
                                    ttgrade += 0.07;
                                } else if (grade.equals( "C")) {
                                    //cagrade += (0.07692307692307692307692307692307692307692308 * 2);
                                    cagrade += 0.05;
                                    ttgrade += 0.05;
                                } else if (grade.equals("D")) {
                                    //cagrade += 0.07692307692307692307692307692307692307692308;
                                    cagrade += 0.02;
                                    ttgrade += 0.02;
                                } else if (grade.equals("F") || grade.equals("X")) {
                                    cagrade += 0;
                                    ttgrade += 0.00;
                                }
                            }
                            else if(gradeId.equals("14")) {
                                if (grade.equals("A")) {
                                    ttgrade += 1.12;
                                    sagrade += 1.12;
                                } else if (grade.equals("B+")) {
                                    ttgrade += 0.98;
                                    sagrade += 0.98;
                                } else if (grade.equals("B")) {
                                    ttgrade += 0.84;
                                    sagrade += 0.84;
                                } else if (grade.equals("C+")) {
                                    ttgrade += 0.7;
                                    sagrade += 0.7;
                                }
                                 else if (grade.equals("C")) {
                                ttgrade += 0.56;
                                sagrade += 0.56;
                                }
                                 else if (grade.equals("D+")) {
                                ttgrade += 0.42;
                                sagrade += 0.42;
                                }
                                else if (grade.equals("D")) {
                                    ttgrade += 0.28;
                                    sagrade += 0.28;
                                }else if (grade.equals("E")) {
                                    ttgrade += 0.14;
                                    sagrade += 0.14;
                                }
                                else if (grade.equals("F") || grade.equals("X")) {
                                    ttgrade += 0;
                                    sagrade += 0;
                                }
                            }
                            else if(gradeId.equals("15")) {
                                if (grade.equals("A")) {
                                    ttgrade += 1.12;
                                    sagrade += 1.12;
                                } else if (grade.equals("B+")) {
                                    ttgrade += 0.98;
                                    sagrade += 0.98;
                                } else if (grade.equals("B")) {
                                    ttgrade += 0.84;
                                    sagrade += 0.84;
                                } else if (grade.equals("C+")) {
                                    ttgrade += 0.7;
                                    sagrade += 0.7;
                                }
                                else if (grade.equals("C")) {
                                    ttgrade += 0.56;
                                    sagrade += 0.56;
                                }
                                else if (grade.equals("D+")) {
                                    ttgrade += 0.42;
                                    sagrade += 0.42;
                                }
                                else if (grade.equals("D")) {
                                    ttgrade += 0.28;
                                    sagrade += 0.28;
                                }else if (grade.equals("E")) {
                                    ttgrade += 0.14;
                                    sagrade += 0.14;
                                }
                                else if (grade.equals("F") || grade.equals("X")) {
                                    ttgrade += 0;
                                    sagrade += 0;
                                }
                            }

                            String caStr = Double.toString(cagrade);
                            String csstrd = df2.format(cagrade);
                            tvCag.setText("CAG: " + csstrd);
                            tvTotal.setText(Double.toString(ttgrade));
                            tvexam.setText("SAG: " + Double.toString(sagrade));


                            String displayResults = "Id: " + gradeId + "\n\nName: "
                                    + grade + "\n";

                            Grade grd = new Grade(gradeId,grade,grade_name);


                            Log.d("cag", caStr);
                        }
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