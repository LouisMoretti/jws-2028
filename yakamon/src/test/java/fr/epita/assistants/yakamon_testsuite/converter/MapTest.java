package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.MapConverter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class MapTest {
    @Inject
    MapConverter mapConverter;

    @Test
    public void basicTest() {

    }

    @Test
    public void nullTest() {
//        assertNull();
    }

    @Test
    public void null2Test() {

    }
}
