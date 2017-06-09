package gaspol.bukahobi.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import gaspol.bukahobi.R;

/**
 * Created by USER on 6/7/2017.
 */

public class GridViewImageViewAdapter extends BaseAdapter {
    private Context context;

    public GridViewImageViewAdapter(Context context) {
        this.context = context;
        initImageIds();
    }

    public List<Integer> imageIds = new ArrayList<Integer>();

    @Override
    public int getCount() {
        return imageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return imageIds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageIds.get(i));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return imageView;
    }

    private void initImageIds () {
        imageIds.add(R.drawable.category_art);
        imageIds.add(R.drawable.category_music);
        imageIds.add(R.drawable.category_sport);
        imageIds.add(R.drawable.category_travel);
    }
}
