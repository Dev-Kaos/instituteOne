package com.institute.one.schooldays.dto;

import com.institute.one.utilities.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchooldayDTO {

    private String name;

    private String description;

    private StateEnum state;

}
