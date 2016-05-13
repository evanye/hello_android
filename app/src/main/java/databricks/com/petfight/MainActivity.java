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
import java.util.Random;

import io.swagger.client.api.PostItServiceApi;
import io.swagger.client.model.PostitPostIt;


public class MainActivity extends AppCompatActivity {

    private static final int[] catImageIds = new int[] {R.drawable.cat0, R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};
    private static final int[] dogImageIds = new int[] {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4};
    private static int cat = 0, dog = 0;

    Random r = new Random();

    private static final String endpoint = "http://postit.dev.databricks.com";
    private static final PostItServiceApi api = new PostItServiceApi();

    private static final String apiKey = "cf73fca1-2fc5-4709-890b-824dc6c1e977";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api.setBasePath(endpoint);
        setContentView(R.layout.activity_main);
    }

    private int getUserId() {
        return r.nextInt(10);
    }

    /** Called when the user clicks the cat button */
    public void catClick(View view) {
        System.out.println("Cat!");
        post(new Payload("cat", getUserId(), cat));
        ImageButton btn = (ImageButton) findViewById(R.id.catButton);
        cat = (cat + 1) % catImageIds.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        btn.setImageBitmap(BitmapFactory.decodeResource(getResources(), catImageIds[cat], options));
    }

    /** Called when the user clicks the dog button */
    public void dogClick(View view) {
        System.out.println("Dog!");
        post(new Payload("dog", getUserId(), dog));
        ImageButton btn = (ImageButton) findViewById(R.id.dogButton);
        dog = (dog + 1) % dogImageIds.length;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        btn.setImageBitmap(BitmapFactory.decodeResource(getResources(), dogImageIds[dog], options));
    }

    public void post(final Payload payload){
        class Task extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    String bodyStr = payload.toString();
                    System.out.println("body: " + bodyStr);
                    PostitPostIt body = new PostitPostIt();
                    body.setApiKey(apiKey);
                    body.setEventTime(System.currentTimeMillis());
                    body.setPayload(bodyStr);
                    api.postIt(body);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        new Task().execute();
    }

    class Payload {
        String pet; int userId; int petId;
        public Payload(String pet, int userId, int petId) {
            this.pet = pet; this.userId = userId; this.petId = petId;
        }
        public String toString() {
            return "{\"pet\": \"" + pet + "\", \"userId\": \"" + userId + "\", \"petId\": \"" + petId + "\"}";
        }
    }
}
