package com.example.devoirlibre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BulletinListAdapter extends ArrayAdapter<Bulletin> {
    private static final String TAG = "BulletinListAdapter";
    private Context mContext;
    int mResource;
    /**
     * Default constructor for the BulletinListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public BulletinListAdapter(Context context, int resource, ArrayList<Bulletin> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String module = getItem(position).getModule();
        Double note = getItem(position).getNote();

        Bulletin bulletin = new Bulletin(module, note);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvModule = (TextView) convertView.findViewById(R.id.moduleAffiche);
        TextView tvNote = (TextView) convertView.findViewById(R.id.noteAffiche);

        tvModule.setText(module);
        tvNote.setText(String.valueOf(note));

        return convertView;
    }
}











