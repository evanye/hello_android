package databricks.com.petfight;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.swagger.client.api.PostItServiceApi;
import io.swagger.client.model.PostitPostIt;


public class MainActivity extends AppCompatActivity {

    private static final int[] catImageIds = new int[] {R.drawable.cat0, R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};
    private static final int[] dogImageIds = new int[] {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3};
    private static int cat = 0, dog = 0;

    private static final String endpoint = "http://postit.dev.databricks.com";
    private static final PostItServiceApi api = new PostItServiceApi();

    private static final String apiKey = "cf73fca1-2fc5-4709-890b-824dc6c1e977";

    private static final String payloadCat = "{\"pet\": \"CAT\"}";
    private static final String payloadDog = "{\"pet\": \"DOG\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api.setBasePath(endpoint);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the cat button */
    public void catClick(View view) {
        System.out.println("Cat!");
        post(payloadCat);
        ImageButton btn = (ImageButton) findViewById(R.id.catButton);
        cat = (cat + 1) % catImageIds.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        btn.setImageBitmap(BitmapFactory.decodeResource(getResources(), catImageIds[cat], options));
    }

    /** Called when the user clicks the dog button */
    public void dogClick(View view) {
        System.out.println("Dog!");
        post(payloadDog);
        ImageButton btn = (ImageButton) findViewById(R.id.dogButton);
        dog = (dog + 1) % dogImageIds.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        btn.setImageBitmap(BitmapFactory.decodeResource(getResources(), dogImageIds[dog], options));
    }

    public void post(final String payload){
        class Task extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    PostitPostIt body = new PostitPostIt();
                    body.setApiKey(apiKey);
                    body.setEventTime(System.currentTimeMillis());
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
