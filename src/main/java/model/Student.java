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


    public Student(String f_name, String l_name, String n_code, String m, String e_type) {
        this.first_name = f_name;
        this.last_name = l_name;
        this.neptune_code = n_code;
        this.major = m;
        this.education_type = e_type;
    }
}
