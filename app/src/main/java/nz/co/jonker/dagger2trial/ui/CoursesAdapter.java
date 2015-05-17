package nz.co.jonker.dagger2trial.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
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
import nz.co.jonker.dagger2trial.BaseApp;
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
        @InjectView(R.id.course_list_item) View mListItem;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Course course = mData.get(position);

        Picasso.with(mContext).load(course.getImage()).into(holder.mImage);
        holder.mTitle.setText(course.getTitle());

        holder.mListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move to detail view here
                Log.d(TAG, "click: " + position);
                Intent intent = new Intent(mContext, CourseDetailActivity.class);
                intent.putExtra("course", course);
                if (((BaseApp) mContext.getApplicationContext()).mCurrentApiVersion >=
                        Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) mContext, (View) holder.mImage, "course_image");
                    mContext.startActivity(intent, options.toBundle());
                } else {
                    mContext.startActivity(intent);
                }
                //todo: move to detail view here
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
