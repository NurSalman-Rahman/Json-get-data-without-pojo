package com.example.jsondataget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    // ArrayList for person names, email Id's and mobile numbers
    ArrayList<String> tList = new ArrayList<>();
    ArrayList<String> nList = new ArrayList<>();
    ArrayList<String> rList = new ArrayList<>();
    ArrayList<String> scList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of RecyclerView
        recyclerView =findViewById(R.id.recyclerViewid);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        String result = "[[{\"t\":\"do\"},{\"t\":\"b\"},{\"t\":\"c\",\"r\":\"14\"},{\"t\":\"b\"},{\"t\":\"dr\"}],{\"0\":{\"t\":\"b\"},\"1\":{\"t\":\"b\"},\"3\":{\"t\":\"s\",\"n\":\"2\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"1\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"3\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"4\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"6\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"5\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"7\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"8\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"10\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"9\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"11\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"12\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"14\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"13\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"15\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"16\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"18\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"17\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"19\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"20\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"22\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"21\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"23\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"24\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"26\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"25\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"27\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"28\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"30\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"29\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"31\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"32\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"34\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"33\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"35\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"36\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"38\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"37\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"39\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"40\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"42\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"41\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"43\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"44\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"46\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"45\",\"sc\":\"0\"}},{\"0\":{\"t\":\"s\",\"n\":\"47\",\"sc\":\"0\"},\"1\":{\"t\":\"s\",\"n\":\"48\",\"sc\":\"0\"},\"3\":{\"t\":\"s\",\"n\":\"50\",\"sc\":\"0\"},\"4\":{\"t\":\"s\",\"n\":\"49\",\"sc\":\"0\"}},[{\"t\":\"s\",\"n\":\"52\",\"sc\":\"0\"},{\"t\":\"s\",\"n\":\"51\",\"sc\":\"0\"},{\"t\":\"s\",\"n\":\"55\",\"sc\":\"0\"},{\"t\":\"s\",\"n\":\"54\",\"sc\":\"0\"},{\"t\":\"s\",\"n\":\"53\",\"sc\":\"0\"}]]";

        try {

            JSONArray userArray = new JSONArray(result);
            // implement for loop for getting users list data

            JSONObject userDetail = null, userDetail2 = null;

            for (int i = 0; i < userArray.length(); i++)
            {
                try {

                    userDetail = userArray.getJSONObject(i);

                }catch (Exception e)
                {
                    JSONArray jArray = new JSONArray(userArray.getString(i));

                    for (int j = 0; j< jArray.length(); j++)
                    {
                        userDetail2 = jArray.getJSONObject(j);
                        setData(userDetail2);
                    }
                    continue;
                }

                // fetch email and name and store it in arraylist
                JsonParserFactory factory=JsonParserFactory.getInstance();
                JSONParser parser=factory.newJsonParser();
                Map jsonMap=parser.parseJson(String.valueOf(userDetail));

                Set<Map.Entry> entries = jsonMap.entrySet();

                for ( Map.Entry entry : entries) {
                    String key= (String) entry.getKey();

                    JSONObject detals = userDetail.getJSONObject(key);

                    setData(detals);

                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, tList,rList, nList, scList);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    private void setData(JSONObject detals) {
        try {
            tList.add(detals.getString("t"));

        }catch (Exception e){
            tList.add("");
        }

        try {
            rList.add(detals.getString("r"));

        }catch (Exception e){
            rList.add("");
        }
        try {
            scList.add(detals.getString("sc"));

        }catch (Exception e){

            scList.add("");
        }

        try {

            nList.add(detals.getString("n"));
        }catch (Exception e){
            nList.add("");
        }
    }

    }