package com.capacitaciones.continuas.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailCourseApprovedDto {
    private String receptor;
    private String topic;
    private String sumary;
    private String nameCourse;
    private Boolean status;
}
