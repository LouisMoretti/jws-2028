package fr.epita.assistants.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_model")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    @ManyToOne
    @JoinColumn (name = "course_id")
    public CourseModel courseId;
}
