package tn.enis.enismap.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import tn.enis.enismap.R;

public class AutoCompletePlacesAdapter extends ArrayAdapter<PlaceItem> {
    private List<PlaceItem> placeListFull;
    private Context context;


    public AutoCompletePlacesAdapter(@NonNull Context context, @NonNull List<PlaceItem> placeList) {
        super(context, 0, placeList);
        placeListFull = new ArrayList<>(placeList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return placeFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.place_autocomplete_row, parent, false
            );
        }
        TextView textViewName = convertView.findViewById(R.id.text_view_name);
        ImageView imageViewFlag = convertView.findViewById(R.id.image_view_flag);
        PlaceItem placeItem = getItem(position);
        if (placeItem != null) {
            textViewName.setText(placeItem.getPlaceName());
            imageViewFlag.setImageResource(placeItem.getLogoImage());


        }


        return convertView;
    }

    private Filter placeFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<PlaceItem> suggestions = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(placeListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (PlaceItem item : placeListFull) {
                    if (item.getPlaceName().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }
            results.values = suggestions;
            results.count = suggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((PlaceItem) resultValue).getPlaceName();
        }
    };
}