package com.example.myapplication;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class singin extends AppCompatActivity {


    EditText ed1,ed2;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);





        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);

        bt1=findViewById(R.id.bt1);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String uname = ed1.getText().toString();
                final String passw = ed2.getText().toString();
                if (uname.length() == 0 && passw.length() == 0) {
                    ed1.setError("Invelid User");
                    ed2.setError("Wrong Password");

                    if (uname.length()==0)
                    {
                        ed1.setError("Envelid User");
                    }
                    if (passw.length()==0)
                    {
                        ed2.setError("Wrong Password");
                    }
                } else

                {
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://ankitgoswami1818.000webhostapp.com/database/urequest.php", new Response.Listener <String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.trim().equals("0"))
                            {
                                Toast.makeText(singin.this, "User Not Found", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Background b=new Background(singin.this);
                                b.setName(uname);

                                Toast.makeText(singin.this, "Sing In Sucess...", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(singin.this,Dashbord.class);
                                startActivity(i);
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {


                            Toast.makeText(singin.this, "No Internet", Toast.LENGTH_SHORT).show();

                        }
                    })

                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            HashMap map=new HashMap();
                            map.put("name",uname);
                            map.put("passsword",passw);

                            return map;


                        }
                    };
                    RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                    queue.add(stringRequest);



                }
            }

        });






    }
}
