package com.example.egpay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.egpay.adaptor.adaptor_list;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataRate> sorts=new ArrayList<>();;


    String moti[];
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        getjson();
        list = new ListView(this);


        setContentView(list);
        Log.e("ssasass",""+sorts.size());
        list.setAdapter(new adaptor_list(MainActivity.this, sorts));

    }

    private void getjson() {
        String json;
        try {
            InputStream is= getAssets().open("data.json");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            int size=is.available();

            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();

            json =new String(buffer,"UTF-8");



            JSONArray jsonArray=new JSONArray(json);
            sortJsonArray(jsonArray);

            JSONArray jsonnew=sortJsonArray(jsonArray);

//            for (int i=0; i<jsonnew.length() ;i++){
//
//            }

            for (int i=0; i<jsonnew.length() ;i++){
                JSONObject obj =jsonnew.getJSONObject(i);
                sorts.add(new DataRate(
                        obj.getInt("id")
                                , obj.getString("name")
                                , obj.getString("required")
                                , obj.getString("type")
                                , obj.getString("default_value")
                                , obj.getString("multiple"),
                                obj.get("sort")
                )
                );


                Log.e("multiple>>> ",obj.getString("multiple"));
                Toast.makeText(this, ""+obj.getString("name"), Toast.LENGTH_SHORT).show();
            }

        }catch (IOException e){

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static JSONArray sortJsonArray(JSONArray array) {
        List<JSONObject> jsons = new ArrayList<JSONObject>();
        for (int i = 0; i < array.length(); i++) {
            try {
                jsons.add(array.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(jsons, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject lhs, JSONObject rhs) {
                String lid = null;
                try {
                    lid = lhs.getString("sort");
                    String rid = rhs.getString("sort");
                    return lid.compareTo(rid);

                } catch (JSONException e) {
                    e.printStackTrace();
                    return 0;
                }
                // Here you could parse string id to integer and then compare.

            }
        });
        return new JSONArray(jsons);
    }

}