package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.MapConverter;
import fr.epita.assistants.yakamon.utils.tile.TileType;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

@QuarkusTest
public class MapTest {
    @Inject
    MapConverter mapConverter;

    @Test
    public void basicTest() {
        String mapString = "1G0\n2W0\n3M0";
        String expected = "1G0;2W0;3M0";
        String result = mapConverter.fileStringToString(mapString);
        assertEquals(expected, result);
    }

    @Test
    public void basic2Test() {
        String mapString = "7GN7SN5WN\n7GS7SS5RS\n7GY7SY5RY\n2GN1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1GN\n9MN9GN1GN";
        String expected = "7GN7SN5WN;7GS7SS5RS;7GY7SY5RY;2GN1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1GN;9MN9GN1GN";
        String result = mapConverter.fileStringToString(mapString);
        assertEquals(expected, result);
    }

    @Test
    public void nullTest() {
        String mapString = "";
        String result = mapConverter.fileStringToString(mapString);
        assertEquals("", result);
    }

    @Test
    public void basic3Test() {
        String map = "7GN7SN5WN;7GS7SS5RS;7GY7SY5RY;2GN1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1GN;9MN9GN1GN";
        String result = mapConverter.fileStringToString(map);
        assertEquals(map, result);
    }

    @Test
    public void basic4Test() {
        String map = "7GN7SN5WN;7GS7SS5RS;7GY7SY5RY;2GN1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1GN;9MN9GN1GN";
        List<List<TileType>> result = mapConverter.stringToMatrix(map);

        assertEquals(5, result.size());
        assertEquals(19, result.get(0).size());
        // TODO: Check the matrix.
    }

    @Test
    public void null2Test() {
        String map = "";
        List<List<TileType>> result = mapConverter.stringToMatrix(map);
        assertNull(result);
    }

    @Test
    public void basic5Test() {
        String mapString = "7GN7SN5WN;7GS7SS5RS;7GY7SY5RY;2GN1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1Gb1Gv1Gn1Gl1Go1Gr1Gy1Gk1GN;9MN9GN1GN";
        List<List<TileType>> map = mapConverter.stringToMatrix(mapString);
        String result = mapConverter.matrixToString(map);
        assertEquals(mapString, result);
    }
}
