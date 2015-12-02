package samdev.de.mvuprobelokalapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import samdev.de.mvuprobelokalapp.R;
import samdev.de.mvuprobelokalapp.other.Achievment;

/**
 * Created by cYa on 02.12.2015.
 */
public class AchievmentListAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<Achievment> list = new ArrayList<>();
    private Context context;

    public AchievmentListAdapter(ArrayList<Achievment> list, Context context) {
        this.list = list;
        this.context = context;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_achievment_layout, null);
        }

        TextView listItemTitle = (TextView)view.findViewById(R.id.achievmentTitle);
        TextView listItemComment = (TextView)view.findViewById(R.id.achievmentComment);
        ImageView listItemImage = (ImageView) view.findViewById(R.id.achievmentIcon);

        Achievment achievment = list.get(position);
        listItemTitle.setText(achievment.getTitle());
        listItemComment.setText(achievment.getComment());
        listItemImage.setImageResource(achievment.getThumbnail());

        return view;
    }
}
