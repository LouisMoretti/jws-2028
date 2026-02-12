package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String map;
}
