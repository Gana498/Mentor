package com.example.manishi;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentRVModal  {
    private String studentID, studentRollNumber, studentFullName, studentBranch, studentSection, studentYear, studentPhone, parentPhone, studentPersonalEmail,
            studentAadhaar, fatherAadhaar, motherAadhaar, studentPresentAddress, studentPermanentAddress;

    protected StudentRVModal(Parcel in) {
        studentID = in.readString();
        studentRollNumber = in.readString();
        studentFullName = in.readString();
        studentBranch = in.readString();
        studentSection = in.readString();
        studentYear = in.readString();
        studentPhone = in.readString();
        parentPhone = in.readString();
        studentPersonalEmail = in.readString();
        studentAadhaar = in.readString();
        fatherAadhaar = in.readString();
        motherAadhaar = in.readString();
        studentPresentAddress = in.readString();
        studentPermanentAddress = in.readString();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getStudentPersonalEmail() {
        return studentPersonalEmail;
    }

    public void setStudentPersonalEmail(String studentPersonalEmail) {
        this.studentPersonalEmail = studentPersonalEmail;
    }

    public String getStudentAadhaar() {
        return studentAadhaar;
    }

    public void setStudentAadhaar(String studentAadhaar) {
        this.studentAadhaar = studentAadhaar;
    }

    public String getFatherAadhaar() {
        return fatherAadhaar;
    }

    public void setFatherAadhaar(String fatherAadhaar) {
        this.fatherAadhaar = fatherAadhaar;
    }

    public String getMotherAadhaar() {
        return motherAadhaar;
    }

    public void setMotherAadhaar(String motherAadhaar) {
        this.motherAadhaar = motherAadhaar;
    }

    public String getStudentPresentAddress() {
        return studentPresentAddress;
    }

    public void setStudentPresentAddress(String studentPresentAddress) {
        this.studentPresentAddress = studentPresentAddress;
    }

    public String getStudentPermanentAddress() {
        return studentPermanentAddress;
    }

    public void setStudentPermanentAddress(String studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
    }

    public StudentRVModal(String studentID, String studentRollNumber, String studentFullName, String studentBranch, String studentSection, String studentYear, String studentPhone, String parentPhone, String studentPersonalEmail, String studentAadhaar, String fatherAadhaar, String motherAadhaar, String studentPresentAddress, String studentPermanentAddress) {
        this.studentID = studentID;
        this.studentRollNumber = studentRollNumber;
        this.studentFullName = studentFullName;
        this.studentBranch = studentBranch;
        this.studentSection = studentSection;
        this.studentYear = studentYear;
        this.studentPhone = studentPhone;
        this.parentPhone = parentPhone;
        this.studentPersonalEmail = studentPersonalEmail;
        this.studentAadhaar = studentAadhaar;
        this.fatherAadhaar = fatherAadhaar;
        this.motherAadhaar = motherAadhaar;
        this.studentPresentAddress = studentPresentAddress;
        this.studentPermanentAddress = studentPermanentAddress;
    }
}
