package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.RenameConverter;
import fr.epita.assistants.yakamon.domain.entity.RenameEntity;
import fr.epita.assistants.yakamon.presentation.api.request.RenameRequest;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class RenameTest {
    @Inject
    RenameConverter renameConverter;

    @Test
    public void basicTest() {
        String uuid = "9f928fa7-aBA1-a496-BcAe-0a463c2E0ece";
        RenameRequest request = new RenameRequest();

        RenameEntity entity = renameConverter.requestToEntity(uuid, request);
        assertEquals(UUID.fromString(uuid), entity.getUuid());
        assertNull(entity.getNewNickname());
    }

    @Test
    public void nullTest() {
        assertNull(renameConverter.requestToEntity(null, new RenameRequest()));
    }

    @Test
    public void null2Test() {
        assertNull(renameConverter.requestToEntity("9f928fa7-aBA1-a496-BcAe-0a463c2E0ece", null));
    }
}
