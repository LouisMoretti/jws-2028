package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.utils.tile.*;
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
            int nbBloc = line.length() / 3;
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

    private String listToString(List<TileType> mapLine) {
        StringBuilder lineString = new StringBuilder();
        for (int i = 0; i < mapLine.size(); i++) {
            Collectible collectible = mapLine.get(i).getCollectible();
            TerrainType terrainType = mapLine.get(i).getTerrainType();

            int nb = 1;
            while (i + nb < mapLine.size()
                    && nb < 9
                    && mapLine.get(i + nb).getCollectible().equals(collectible)
                    && mapLine.get(i).getTerrainType().equals(terrainType)) {
                nb++;
            }

            lineString.append(nb);
            lineString.append(terrainType.getValue());
            lineString.append(collectible.getCollectibleInfo().getValue());

            i += nb - 1;
        }

        return lineString.toString();
    }

    public String matrixToString(List<List<TileType>> map) {
        StringBuilder mapString = new StringBuilder();
        mapString.append(listToString(map.getFirst()));
        for (int i = 1; i < map.size(); i++) {
            mapString.append(';');
            mapString.append(listToString(map.get(i)));
        }

        return mapString.toString();
    }
}
