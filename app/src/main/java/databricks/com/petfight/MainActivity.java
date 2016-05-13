package databricks.com.petfight;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.swagger.client.api.PostItServiceApi;
import io.swagger.client.model.PostitPostIt;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String endpoint = "http://postit.dev.databricks.com";
    private static final PostItServiceApi api = new PostItServiceApi();

    private static final String apiKey = "a2f4f593-720e-405f-9304-12dfe6915cc3";

    private static final String payloadCat = "{\"name\": \"CAT\", \"age\": 24 }";
    private static final String payloadDog = "{\"name\": \"DOG\", \"age\": 24 }";


    /** Called when the user clicks the cat button */
    public void catClick(View view) {
        System.out.println("Cat!");
        post(payloadCat);
    }

    /** Called when the user clicks the dog button */
    public void dogClick(View view) {
        System.out.println("Dog!");
        post(payloadDog);
    }

    public void post(final String payload){
        class Task extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    api.setBasePath(endpoint);
                    PostitPostIt body = new PostitPostIt();
                    body.setApiKey(apiKey);
                    body.setEventTime(System.nanoTime());
                    body.setPayload(payload);
                    api.postIt(body);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        new Task().execute();
    }
}
