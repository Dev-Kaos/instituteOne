package com.institute.one.schooldays.dto;

import com.institute.one.utilities.enums.StateEnum;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchooldayDTO {

    @NotEmpty
    private String name;
    
    @NotEmpty
    private String description;

    private StateEnum state;

}
