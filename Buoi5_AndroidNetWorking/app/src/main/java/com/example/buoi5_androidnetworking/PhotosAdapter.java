package com.example.buoi5_androidnetworking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotosAdapter extends ArrayAdapter<Photos> {

    private ArrayList<Photos> list;
    Context mContext;
    private static class ViewHolder{
        TextView tvId;
        TextView tvTitle;
        ImageView avatar;
    }

    public PhotosAdapter( ArrayList<Photos> list, Context context) {
        super(context, R.layout.itemphoto,list);
        this.list = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Photos photos = getItem(position);
       ViewHolder viewHolder;
       final View result;
       if(convertView == null){
           viewHolder = new ViewHolder();
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.itemphoto,parent,false);
           viewHolder.avatar  = convertView.findViewById(R.id.avatar);
           viewHolder.tvId = convertView.findViewById(R.id.tvId);
           viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
           convertView.setTag(viewHolder);
       }else{
           viewHolder = (ViewHolder) convertView.getTag();

       }
        viewHolder.tvId.setText("id :" + photos.id);
        viewHolder.tvTitle.setText("title :" + photos.title);
        Picasso.get().load(photos.thumbnailUrl).fit().into(viewHolder.avatar);
        return convertView;
    }
}
