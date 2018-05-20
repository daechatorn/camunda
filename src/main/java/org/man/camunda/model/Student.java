package org.man.camunda.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class Student {
    public String studentId;
    public String grade;
    public int gradeNumber;
}
