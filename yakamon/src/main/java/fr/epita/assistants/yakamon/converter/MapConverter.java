package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.utils.tile.Collectible;
import fr.epita.assistants.yakamon.utils.tile.CollectibleUtils;
import fr.epita.assistants.yakamon.utils.tile.TerrainType;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MapConverter {
    public String fileStringToString(String fileString) {
        return fileString.replaceAll("\n", ";");
    }

    public List<List<TileType>> stringToMatrix(String map) {
        List<List<TileType>> tiles = new ArrayList<List<TileType>>();

        String[] lines = map.split(";");
        for (String line : lines) {
            List<TileType> lineTiles = new ArrayList<TileType>();
            int nbBloc = line.length()/3;
            for (int i = 0; i < nbBloc; i++) {
                int nb = line.charAt(i * 3) - '0';

                TerrainType terrainType = TerrainType.getTerrain(line.charAt(i * 3 + 1));
                Collectible collectible = CollectibleUtils.getCollectible(line.charAt(i * 3 + 2));

                TileType tile = new TileType(terrainType, collectible);
                for (int j = 0; j < nb; j++) {
                    lineTiles.add(tile);
                }
            }
            tiles.add(lineTiles);
        }

        if (tiles.isEmpty())
            return null;
        return tiles;
    }

    public String matrixToString(List<List<TileType>> map) {
        throw new NotImplementedException();
    }
}
