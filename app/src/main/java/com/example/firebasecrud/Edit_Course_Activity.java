package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Edit_Course_Activity extends AppCompatActivity {

    private TextInputLayout courseNameEdt , coursePriceEdt , courseSuitedForEdt  , courseImageEdt , courseLinkEdt , courseDescEdt;
    private Button updateCourseBtn , deleteCourseBtn;
    private ProgressBar loadingPb;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private  String courseId;
    private courseRvModel courseRvModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);


        courseNameEdt = findViewById(R.id.idEdtCourseName);
        coursePriceEdt = findViewById(R.id.idEdtCoursePrice);
        courseSuitedForEdt = findViewById(R.id.idEdtCourseSuitedFor);
        courseImageEdt = findViewById(R.id.idEdtCourseImageLink);
        courseLinkEdt = findViewById(R.id.idEdtCourseLink);
        courseDescEdt =findViewById(R.id.idEdtCourseDesc);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDeleteCourse);
        loadingPb = findViewById(R.id.idPbLoading);
        firebaseDatabase= FirebaseDatabase.getInstance();

        courseRvModel = getIntent().getParcelableExtra("course");
        if(courseRvModel!= null){
            courseNameEdt.setText()
        }



        databaseReference = firebaseDatabase.getReference("Courses").child(courseId);



    }
}