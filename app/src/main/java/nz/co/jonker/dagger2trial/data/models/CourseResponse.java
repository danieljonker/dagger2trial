package nz.co.jonker.dagger2trial.data.models;

import java.util.ArrayList;

/**
 * Created by jonker on 15/05/15.
 */
public class CourseResponse {
    ArrayList<Course> courses;

    public CourseResponse() {
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}
