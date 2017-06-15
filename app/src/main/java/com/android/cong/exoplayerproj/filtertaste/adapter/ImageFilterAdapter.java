package com.android.cong.exoplayerproj.filtertaste.adapter;

import java.util.ArrayList;
import java.util.List;

import com.android.cong.exoplayerproj.R;
import com.android.cong.exoplayerproj.filtertaste.filters.ImageFilterType;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by xiaokecong on 15/06/2017.
 */

public class ImageFilterAdapter extends ArrayAdapter<ImageFilterType> {

    static class ViewHolder {
        public TextView text;
    }

    private final Context context;
    private final ArrayList<ImageFilterType> values;

    public ImageFilterAdapter(Context context, int resource, List<ImageFilterType> objects) {
        super(context, resource, objects);
        this.context = context;
        values = (ArrayList<ImageFilterType>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
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
        holder.text.setText(values.get(position).name());

        return rowView;
    }
}
