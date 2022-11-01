package com.grade.tracker.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConstants {
    public static final String LASTNAME = "lastName";
    public static final String FIRSTNAME = "firstName";
    public static final String PARAM_ID="/{id}";
    public static final String SAVE="/save";
    public static final String GRADES="/grades";
    public static final String DELETE="/delete";
    public static final String UPDATE="/update";
    public static final String PARAM_STUDENT_ID="/{studentId}" ;
    public static final String PARAM_SUBJECT_ID="/{subjectId}";
    public static final String SUBJECTS="/subjects";

    public static final String SCHOOL_CLASS="/school-class";
    public static final String STUDENTS="/students";
    public static final String TEACHERS="/teachers";
    public static final String PARAM_SCHOOL_CLASS_ID="/{schoolClassId}";
}
