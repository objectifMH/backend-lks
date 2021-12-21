package com.lks.backendtechnicaltest;

import com.lks.backendtechnicaltest.entity.Actor;
import com.lks.backendtechnicaltest.service.ActorService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BackendTechnicalTestApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Debut des tests ! ");
    }

    @Autowired
    private ActorService actorService;

    @Test
    public void shouldSaveActor() {
        System.out.println("Should save actor !! ");
        Actor expectedActor = Actor.builder().name("Tom Cruise").build();
        Actor saveActor = actorService.save(expectedActor);

        assertNotNull(saveActor);
        assertNotNull(saveActor.getId());
        assertNotNull(saveActor.getName());
        assertEquals(expectedActor.getName(), saveActor.getName());

    }

}
