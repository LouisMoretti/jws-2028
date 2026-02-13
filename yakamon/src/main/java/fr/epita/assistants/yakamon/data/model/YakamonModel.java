package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "yakamon")
@Getter
@Setter
public class YakamonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID uuid;
    public String nickname;
    @Column(name = "energy_points")
    public Integer energyPoints;
    @ManyToOne
    @JoinColumn(name = "yakadex_entry_id")
    public YakadexEntryModel yakadexEntryId;
}
