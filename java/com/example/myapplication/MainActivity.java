package com.example.myapplication;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        e6=findViewById(R.id.e6);

        b2=findViewById(R.id.b2);


        b1=findViewById(R.id.b1);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String name1=e1.getText().toString();
                final String phone1=e2.getText().toString();
                final String mail1=e3.getText().toString();
                final String add1=e4.getText().toString();
                final String cor1=e5.getText().toString();
                final String pass1=e6.getText().toString();
                if(name1.length()==0&&pass1.length()==0&&mail1.length()==0&&add1.length()==0&&cor1.length()==0&&pass1.length()==0)
                {
                    e1.setError("Enter Name");
                    e2.setError("Mobail Number");
                    e3.setError("xyz@mail.com");
                    e4.setError("Address");
                    e5.setError("Course");
                    e6.setError("Password ***");
                }
                else if (name1.length()==0)
                {
                    e1.setError("Enter Name");
                }
                else if (phone1.length()==0)
                {
                    e2.setError("Enter Phone");
                }
                else if (mail1.length()==0)
                {
                    e3.setError("XYZ@mail.com");
                }
                else if (add1.length()==0)
                {
                    e4.setError("Enter Address");
                }
                else if (cor1.length()==0)
                {
                    e5.setError("Enter Course");
                }
                else if (pass1.length()==0)
                {
                    e6.setError("Enter Password");
                }
                else {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://ankitgoswami1818.000webhostapp.com/database/ucon.php", new Response.Listener <String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "Register Sucess...", Toast.LENGTH_SHORT).show();


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            HashMap map=new HashMap();
                            map.put("name",name1);
                            map.put("phone",phone1);
                            map.put("emial",mail1);
                            map.put("address",add1);
                            map.put("course",cor1);
                            map.put("passsword",pass1);



                            return map;
                        }
                    };
                    RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                    queue.add(stringRequest);
                    Intent i=new Intent(MainActivity.this,Dashbord.class);
                    startActivity(i);



                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i2=new Intent(MainActivity.this,singin.class);
                startActivity(i2);

            }
        });
    }
}
