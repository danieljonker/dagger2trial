package nz.co.jonker.dagger2trial.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nz.co.jonker.dagger2trial.R;
import nz.co.jonker.dagger2trial.data.models.Course;

/**
 * Created by jonker on 15/05/15.
 */
public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
    public static final String TAG = "TodayAdapter";

    List<Course> mData;
    Context mContext;

    public CoursesAdapter(List<Course> mData, Context context) {
        this.mData = mData;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.title) TextView mTitle;
        @InjectView(R.id.image) ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Course course = mData.get(position);

        Picasso.with(mContext).load(course.getImage()).into(holder.mImage);
        holder.mTitle.setText(course.getTitle());

//        holder.mItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //move to detail view here
//                Log.d(TAG, "click: " + position);
//                //todo: move to detail view here
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
