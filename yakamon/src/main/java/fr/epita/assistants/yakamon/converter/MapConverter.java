package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.utils.tile.TileType;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

@ApplicationScoped
public class MapConverter {
    public String fileStringToString(String fileString) {
        return fileString.replaceAll("\n", ";");
    }

    public List<List<TileType>> stringToMatrix(String map) {
        return null;
    }

    public String matrixToString(List<List<TileType>> map) {
        throw new NotImplementedException();
    }
}
