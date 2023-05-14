package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Add_Course_Activity extends AppCompatActivity {

   private   TextInputLayout courseNameEdt , coursePriceEdt , courseSuitedForEdt  , courseImageEdt , courseLinkEdt , courseDescEdt;
    private Button addCourseBtn;
    private ProgressBar loadingPb;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private String courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

courseNameEdt = findViewById(R.id.idEdtCourseName);
coursePriceEdt = findViewById(R.id.idEdtCoursePrice);
courseSuitedForEdt = findViewById(R.id.idEdtCourseSuitedFor);
courseImageEdt = findViewById(R.id.idEdtCourseImageLink);
courseLinkEdt = findViewById(R.id.idEdtCourseLink);
courseDescEdt =findViewById(R.id.idEdtCourseDesc);
addCourseBtn = findViewById(R.id.idBtnAddCourse);
loadingPb = findViewById(R.id.idPbLoading);
firebaseDatabase= FirebaseDatabase.getInstance();
databaseReference = firebaseDatabase.getReference("Courses");

addCourseBtn.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        String courseName = courseNameEdt.getEditText().toString();
        String coursePrice = coursePriceEdt.getText().toString();
        String SuitedFor = courseSuitedForEdt.getText().toString();
        String courseImg = courseImageEdt.getText().toString();
        String courseLink = courseLinkEdt.getText().toString();
        String courseDesc = courseDescEdt.getText().toString();

        courseId = courseName;

        courseRvModel courseRvModel= new courseRvModel("courseId" , courseName , coursePrice ,SuitedFor,courseImg , courseLink ,courseDesc  );

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 databaseReference.child(courseId).setValue(courseRvModel);
                Toast.makeText(Add_Course_Activity.this, "Course Add", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Add_Course_Activity.this , MainActivity.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Add_Course_Activity.this, "Error is " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }
});


    }
}