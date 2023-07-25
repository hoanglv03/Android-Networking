package com.example.buoi5_androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.webkit.HttpAuthHandler;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BackgroundGET extends AsyncTask<Void,Void,Void> {
    private String TAG = MainActivity.class.getSimpleName();
    public static String url = "https://jsonplaceholder.typicode.com/photos";
    ArrayList<Photos> listPhoto;
    private ProgressDialog progressDialog;
    private ListView lv;
    Context context;
    PhotosAdapter photosAdapter;

    public BackgroundGET( ListView lv, Context context) {
        this.listPhoto = new ArrayList<>();
        this.lv = lv;
        this.context = context;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        photosAdapter = new PhotosAdapter(listPhoto,context);
        lv.setAdapter(photosAdapter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
       HttpHalder hanlder= new HttpHalder();
       String jsonStr = hanlder.makeServiceCall(url);
       if(jsonStr != null){
           try {
               JSONArray jsonArray = new JSONArray(jsonStr);
               for(int i = 0; i< jsonArray.length();i++){
                   JSONObject c = jsonArray.getJSONObject(i);
                   int id =c.getInt("id");
                   String title =c.getString("title");
                   String thumbnailUrl =c.getString("thumbnailUrl");

                   Photos photosObj = new Photos();
                   photosObj.setId(id);
                   photosObj.setTitle(title);
                   photosObj.setThumbnailUrl(thumbnailUrl);
                   listPhoto.add(photosObj);
               }
           }catch (Exception e){
               e.printStackTrace();
           }
       }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("senđing.....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
