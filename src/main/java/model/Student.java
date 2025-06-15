package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String neptune_code;
    private String major;
    private String education_type;

}
