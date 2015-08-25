package com.example.tropo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Syafiq Azlan on 5/7/2015.
 */
public class Fetch_JKA_Office extends Activity
{

    ArrayList<Data> dataList = new ArrayList<Data>();
    String url ="http://tropopsis2015.net84.net/database/uasrama.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetch);
        new BackTask().execute(url);
        addListenerOnButton();
    }


    public void addListenerOnButton() {
        Button close_button = (Button) findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public class BackTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = HttpURLConnect.getData(url);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            try {

                JSONArray ar = new JSONArray(s);
                for (int i=0; i<ar.length(); i++){
                    JSONObject jsonobject = ar.getJSONObject(i);
                    Data name = new Data();
                    name.setName(jsonobject.getString("name"));
                    dataList.add(name);
                }
            }
            catch (JSONException e){
                e.printStackTrace();
            }

            DataAdapter adapter = new DataAdapter(Fetch_JKA_Office.this, R.layout.data_list_items, dataList);
            ListView lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adapter);
            addListenerOnButton();
            //Log.d("recived",s);
        }
    }

}


