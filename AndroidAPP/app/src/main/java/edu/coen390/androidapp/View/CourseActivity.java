package edu.coen390.androidapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examapp.R;

import java.util.List;

import edu.coen390.androidapp.Controller.DatabaseHelper;
import edu.coen390.androidapp.CourseAdapter;
import edu.coen390.androidapp.Model.Course;
import edu.coen390.androidapp.Model.User;

public class CourseActivity extends AppCompatActivity {


    private static final String TAG = "CourseActivity";
    protected ListView courseListView;
    protected DatabaseHelper dbHelper;
    protected List<Course> courses;
    protected int invigilator_id;
    private TextView userNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        setupUI();
    }

    private void setupUI() {

        dbHelper = new DatabaseHelper(this);
        courseListView = findViewById(R.id.courseListView);
        userNameTextView = findViewById(R.id.userNameTextView);


/*
        //this will be replaced with the code below
        invigilator_id = intent.getIntExtra("invigilator_id",0);
        Log.d(TAG,"after getLongEXTRa " + invigilator_id);
        userNameTextView.setText("User name"); //this will be replaced with username of invigilator that is logged in
  */


        Intent intent = getIntent();
        // TODO: Get object from LoginActivity. Set username to text view
        User invigilator = (User) intent.getSerializableExtra("invigilatorObject");
        userNameTextView.setText(invigilator.getUserName());

        loadListView(invigilator.getId());


        courseListView.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent1 = new Intent(view.getContext(), VerificationModeActivity.class);
            Course currentCourse = new Course(courses.get(position).getId(),
                    courses.get(position).getInvigilator_id(),
                    courses.get(position).getTitle(),
                    courses.get(position).getCode(),
                    courses.get(position).getNumOfStudents());
            intent1.putExtra(VerificationModeActivity.COURSE_INTENT, currentCourse);
            startActivity(intent1);
        });

    }

    private void loadListView(long invigilatorID) {

        courses = dbHelper.getCourses(invigilatorID);
        CourseAdapter adapter = new CourseAdapter(CourseActivity.this, courses);
        courseListView.setAdapter(adapter);


    }


}