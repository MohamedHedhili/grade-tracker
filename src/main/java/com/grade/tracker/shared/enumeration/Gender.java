package com.grade.tracker.shared.enumeration;

import lombok.Getter;

@Getter
public enum Gender {
    M("Male"), F("Female");
    private final String gender ;

    Gender(final String gender) {
        this.gender = gender;
    }
}
