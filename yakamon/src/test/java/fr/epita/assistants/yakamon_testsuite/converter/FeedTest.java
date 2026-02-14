package fr.epita.assistants.yakamon_testsuite.converter;

import fr.epita.assistants.yakamon.converter.FeedConverter;
import fr.epita.assistants.yakamon.domain.entity.FeedEntity;
import fr.epita.assistants.yakamon.presentation.api.request.FeedRequest;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class FeedTest {
    @Inject
    FeedConverter feedConverter;

    @Test
    public void basicTest() {
        String uuid = "9f928fa7-aBA1-a496-BcAe-0a463c2E0ece";
        FeedRequest request = new FeedRequest();
        request.setQuantity(42);

        FeedEntity entity = feedConverter.requestToEntity(uuid, request);
        assertEquals(entity.getUuid(), UUID.fromString(uuid));
        assertEquals(42, entity.getQuantity());
    }

    @Test
    public void nullTest() {
        FeedEntity entity = feedConverter.requestToEntity("uuid", null);
        assertNull(entity);
    }

    @Test
    public void null2Test() {
        FeedEntity entity = feedConverter.requestToEntity(null, new FeedRequest());
        assertNull(entity);
    }
}
