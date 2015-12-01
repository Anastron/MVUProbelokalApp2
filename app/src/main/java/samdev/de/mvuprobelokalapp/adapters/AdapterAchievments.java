package samdev.de.mvuprobelokalapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import samdev.de.mvuprobelokalapp.R;
import samdev.de.mvuprobelokalapp.other.Achievment;

/**
 * Created by cYa on 01.12.2015.
 */
public class AdapterAchievments extends RecyclerView.Adapter<AdapterAchievments.ViewHolderAchievments> {

    private ArrayList<Achievment> listAchievments = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public AdapterAchievments(Context context){
        layoutInflater = LayoutInflater.from(context);

    }

    public void setAchievmentList(ArrayList<Achievment> listAchievments){
        this.listAchievments = listAchievments;
       notifyItemRangeChanged(0, listAchievments.size());
    }

    @Override
    public ViewHolderAchievments onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_achievment_layout, parent, false);
        ViewHolderAchievments viewHolder = new ViewHolderAchievments(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderAchievments holder, int position) {
        Achievment currentAchievment = listAchievments.get(position);
        holder.achievmentTitle.setText(currentAchievment.getTitle());
        holder.achievmentComment.setText(currentAchievment.getComment());
        holder.achievmentThumbnail.setImageDrawable(Drawable.createFromPath(currentAchievment.getThumbnail()));
    }

    @Override
    public int getItemCount() {
        return listAchievments.size();
    }

    static class ViewHolderAchievments extends RecyclerView.ViewHolder{

        private ImageView achievmentThumbnail;
        private TextView achievmentTitle;
        private TextView achievmentComment;

        public ViewHolderAchievments(View itemView){
            super(itemView);
            achievmentThumbnail = (ImageView) itemView.findViewById(R.id.achievmentThumbnail);
            achievmentTitle = (TextView) itemView.findViewById(R.id.achievmentTitle);
            achievmentComment = (TextView) itemView.findViewById(R.id.achievmentComment);
        }
    }
}
