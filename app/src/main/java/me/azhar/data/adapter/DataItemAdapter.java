package me.azhar.data.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.azhar.data.R;
import me.azhar.data.model.DataItem;

public class DataItemAdapter extends ArrayAdapter<DataItem> {

    private List<DataItem> mDataItems;
    private LayoutInflater mInflater;

    public DataItemAdapter(@NonNull Context context, @NonNull List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.itemNameText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        DataItem item = mDataItems.get(position);

        tvName.setText(item.getItemName());
        //imageView.setImageResource(R.drawable.apple_pie);

        String imageFile=item.getImage();
        InputStream inputStream= null;
        try {
            inputStream = getContext().getAssets().open(imageFile);
            Drawable d=Drawable.createFromStream(inputStream,null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return convertView;
    }
}
