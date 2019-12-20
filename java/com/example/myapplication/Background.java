package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Background {
    Context context;
    SharedPreferences sharedPreferences;
    private String name;

    public void removeuser(){
        sharedPreferences.edit().clear().commit();
    }
    public String getName() {
      name=sharedPreferences.getString("userinformation","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        sharedPreferences.edit().putString("userinformation",name).commit();
    }

    public  Background(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences("com.example.myapplication",Context.MODE_PRIVATE);

    }
}
