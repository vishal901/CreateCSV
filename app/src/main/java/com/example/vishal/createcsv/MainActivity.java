package com.example.vishal.createcsv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> li1 = new ArrayList<String>(){
            {
                this.add("animal");
                this.add("nuts");
                this.add("java");
            }
        };


        System.out.println( getListAsCsvString(li1));

    }

    public String getListAsCsvString(List<String> list){

        StringBuilder sb = new StringBuilder();
        for(String str:list){
            if(sb.length() != 0){
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
