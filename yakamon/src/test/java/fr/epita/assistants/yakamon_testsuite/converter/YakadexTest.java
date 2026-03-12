package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.YakadexConverter;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntity;
import fr.epita.assistants.yakamon.domain.entity.YakadexEntryEntity;
import fr.epita.assistants.yakamon.presentation.api.response.YakadexResponse;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.annotation.ElementType;
import java.util.List;

@QuarkusTest
public class YakadexTest {
    @Inject
    YakadexConverter yakadexConverter;

    @Test
    public void basicTest() {
        YakadexEntryEntity entry = new YakadexEntryEntity(42, "sh", null, null, 1, 2, true, "jsp");
        YakadexEntity yakadexEntity = new YakadexEntity(List.of(entry));

        YakadexResponse yakadexResponse = yakadexConverter.entityToResponse(yakadexEntity);
        assertEquals(1, yakadexResponse.getEntries().size());
        assertEquals(42, yakadexResponse.getEntries().get(0).getId());
        assertEquals("sh", yakadexResponse.getEntries().get(0).getName());
    }

    @Test
    public void nullTest() {
        assertNull(yakadexConverter.entityToResponse(null));
    }
}
