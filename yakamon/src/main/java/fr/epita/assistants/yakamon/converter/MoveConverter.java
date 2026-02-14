package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.domain.entity.MoveEntity;
import fr.epita.assistants.yakamon.presentation.api.response.MoveResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MoveConverter {
    public MoveResponse entityToResponse(MoveEntity move) {
        if (move == null || move.getPosition() == null) return null;
        return new MoveResponse(move.getPosition().getPosX(), move.getPosition().getPosY());
    }
}
