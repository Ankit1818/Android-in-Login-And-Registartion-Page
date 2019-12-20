package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Dashbord extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     getMenuInflater().inflate(R.menu.mainmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.l1:


                sharedPreferences=getSharedPreferences("com.example.myapplication",MODE_PRIVATE);

               /* sharedPreferences.edit().clear().commit();
                startActivity(new Intent(Dashbord.this,MainActivity.class));
                finish();
*/

               new Background(getApplicationContext()).removeuser();


               Intent i=new Intent(Dashbord.this,MainActivity.class);
                startActivity(i);
                finish();


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
