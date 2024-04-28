package com.veljko121.backend.dto.tours;

import com.veljko121.backend.core.enums.PersonalTourRequestStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalTourRequestUpdateDTO {

    private Integer id;

    private PersonalTourRequestStatus status;

}
