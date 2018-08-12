package com.example.siva1.bunky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.RestAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    EditText roll=null;
    EditText pass=null;
    Button submit=null;
    String ROOT_URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        roll= (EditText) findViewById(R.id.et_roll);
        pass= (EditText) findViewById(R.id.et_pass);
        submit= (Button) findViewById(R.id.bt_submit);
        ROOT_URL="http://sample-env.7dj2a4dqcw.us-west-2.elasticbeanstalk.com";
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollnum=roll.getText().toString();
                String passwrd=pass.getText().toString();
                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL).setLogLevel(RestAdapter.LogLevel.FULL)
                        .build();
                Call api = adapter.create(Call.class);
                if((!rollnum.equals(""))&&(!passwrd.equals(""))) {
                    api.getLogin(rollnum, passwrd, new Callback<Response>() {
                        @Override
                        public void success(Response response, Response response2) {
                            String res = convertToResponseString(response);
                            //System.out.println(response.b);
                            RespObj resps = (RespObj) GsonHelper.getGson(res, RespObj.class);
                            if(resps.Name!=null) {
                                System.out.println(resps);
                                Intent intent = new Intent(MainActivity.this, DisplayInfo.class);
                                intent.putExtra("obj", resps);
                                startActivity(intent);
                            }else{
                                roll.setText("");
                                pass.setText("");
                                Toast.makeText(MainActivity.this,"Wrong Credentials.Please Reenter.",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    static public  String convertToResponseString(Response response) {
        // Try to get response body
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
            String line;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = sb.toString();
        return result;
    }

}
