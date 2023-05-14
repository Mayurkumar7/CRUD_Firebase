package com.example.firebasecrud;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class courseRvModel implements Parcelable {
    private  String courseName;
    private String courseDescription;
    private String coursePrice;
     private String bestSuitedFor;
     private  String courseImg;
     private String courseLink;
     private String courseId;

     public courseRvModel(){

     }

    protected courseRvModel(Parcel in) {
        courseName = in.readString();
        courseDescription = in.readString();
        coursePrice = in.readString();
        bestSuitedFor = in.readString();
        courseImg = in.readString();
        courseLink = in.readString();
        courseId = in.readString();
    }

    public static final Creator<courseRvModel> CREATOR = new Creator<courseRvModel>() {
        @Override
        public courseRvModel createFromParcel(Parcel in) {
            return new courseRvModel(in);
        }

        @Override
        public courseRvModel[] newArray(int size) {
            return new courseRvModel[size];
        }
    };

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getBestSuitedFor() {
        return bestSuitedFor;
    }

    public void setBestSuitedFor(String bestSuitedFor) {
        this.bestSuitedFor = bestSuitedFor;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public courseRvModel(String courseName, String courseDescription, String coursePrice, String bestSuitedFor, String courseImg, String courseLink, String courseId) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.bestSuitedFor = bestSuitedFor;
        this.courseImg = courseImg;
        this.courseLink = courseLink;
        this.courseId = courseId;



    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(courseName);
        dest.writeString(courseDescription);
        dest.writeString(coursePrice);
        dest.writeString(bestSuitedFor);
        dest.writeString(courseImg);
        dest.writeString(courseLink);
        dest.writeString(courseId);
    }
}