package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "yakamon")
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
