package fr.epita.assistants.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course_model")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn
    public Long id;
    public String name;
    @ElementCollection
    @CollectionTable(name = "course_model_tags", joinColumns = @JoinColumn(name = "course_id"))
    public List<String> tag;
}
