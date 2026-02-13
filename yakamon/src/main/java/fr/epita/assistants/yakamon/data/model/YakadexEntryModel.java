package fr.epita.assistants.yakamon.data.model;

import fr.epita.assistants.yakamon.utils.ElementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "yakadex_entry")
@Getter
@Setter
public class YakadexEntryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JoinColumn
    public Integer id;
    public String name;
    public Boolean caught;
    @Column(name = "first_type")
    @Enumerated(EnumType.STRING)
    public ElementType firstType;
    @Enumerated(EnumType.STRING)
    @Column(name = "second_type")
    public ElementType secondType;
    public String description;
    @OneToOne
    @JoinColumn(name = "evolution_id")
    public YakadexEntryModel evolution;
    @Column(name = "evolve_threshold")
    public Integer evolveThreshold;
}
