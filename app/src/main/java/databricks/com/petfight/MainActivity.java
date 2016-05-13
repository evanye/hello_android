package databricks.com.petfight;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String endpoint = "http://postit.dev.databricks.com/api/1.0";

    private static final String apiKey = "a2f4f593-720e-405f-9304-12dfe6915cc3";

    private static final String payloadCat = "{\"api_key\": \"a2f4f593-720e-405f-9304-12dfe6915cc3\", \"payload\": \"{\\\"name\": \\\"CAT\\\", \\\"age\\\": 24 }\"}";
    private static final String payloadDog = "{\"api_key\": \"a2f4f593-720e-405f-9304-12dfe6915cc3\", \"payload\": \"{\\\"name\": \\\"DOG\\\", \\\"age\\\": 24 }\"}";


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
                    URL url = new URL(endpoint);
                    byte[] postData       = payload.getBytes();
                    int    postDataLength = postData.length;

                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setDoOutput( true );
                    conn.setInstanceFollowRedirects( false );
                    conn.setRequestMethod( "POST" );
//                    conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
//                    conn.setRequestProperty( "charset", "utf-8");
                    conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
                    conn.setUseCaches( false );
                    DataOutputStream wr = new DataOutputStream( conn.getOutputStream());
                    wr.write( postData );
                    System.out.println(payload);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        new Task().execute();
    }
}
