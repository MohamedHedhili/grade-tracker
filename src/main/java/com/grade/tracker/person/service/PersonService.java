package com.grade.tracker.person.service;

import com.grade.tracker.person.dto.PersonRequestDto;
import com.grade.tracker.person.dto.PersonResponseDto;
import com.grade.tracker.shared.exception.InternalException;


import java.util.List;

public interface PersonService <T extends PersonRequestDto , U extends PersonResponseDto>{
    U save(final T personRequestDto) throws InternalException;


}
