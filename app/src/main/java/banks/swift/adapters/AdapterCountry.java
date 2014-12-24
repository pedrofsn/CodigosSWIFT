package banks.swift.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import banks.swift.R;

public class AdapterCountry extends BaseAdapter {

    private final Context context;
    private final List<String> list;

    public AdapterCountry(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder viewHolder;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.adapter_country, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewCountry = (TextView) v.findViewById(R.id.textViewCountry);

            v.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        String nomeDoPais = list.get(position);

        if (nomeDoPais != null) {
            viewHolder.textViewCountry.setText(nomeDoPais);
            v.setTag(viewHolder);
        }

        return v;
    }

    public static class ViewHolder {
        public TextView textViewCountry;
    }
}