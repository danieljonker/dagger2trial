package nz.co.jonker.dagger2trial.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nz.co.jonker.dagger2trial.BaseActivity;
import nz.co.jonker.dagger2trial.R;
import nz.co.jonker.dagger2trial.data.models.Course;

public class CourseDetailActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.image)
    ImageView mImage;
    @InjectView(R.id.title)
    TextView mTitle;

    Course mCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        ButterKnife.inject(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mCourse = extras.getParcelable("course");
        } else {
            //return?
        }

        Picasso.with(this).load(mCourse.getImage()).into(mImage);
        mTitle.setText(mCourse.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}