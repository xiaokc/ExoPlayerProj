package com.android.cong.exoplayerproj.filtertaste.adapter;

import java.util.ArrayList;
import java.util.List;

import com.android.cong.exoplayerproj.R;
import com.android.cong.exoplayerproj.filtertaste.filters.CameraFilterType;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by xiaokecong on 15/06/2017.
 */

public class CameraFilterAdapter extends ArrayAdapter<CameraFilterType> {

    static class ViewHolder {
        public TextView text;
    }

    private final Context context;
    private final ArrayList<CameraFilterType> values;

    public CameraFilterAdapter(Context context, int resource, List<CameraFilterType> objects) {
        super(context, resource, objects);
        this.context = context;
        values = (ArrayList<CameraFilterType>) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.filter_list_row_text, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = values.get(position).name();
        holder.text.setText(s);

        return rowView;
    }
}
