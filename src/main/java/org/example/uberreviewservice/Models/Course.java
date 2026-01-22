package org.example.uberreviewservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseModel{

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students= new ArrayList<>();
}
