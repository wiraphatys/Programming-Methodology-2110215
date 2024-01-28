package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import logic.ghost.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PooYaGhost;
import utils.GameUtils;

import java.util.ArrayList;

class PooYaGhostTest {

    PooYaGhost pooYaGhost;

    @BeforeEach
    void setUp() {
        pooYaGhost = new PooYaGhost(2);
    }

    @Test
    void testIsDestroyedFalse() {
        assertFalse(pooYaGhost.isDestroyed());
    }

    @Test
    void testIsDestroyedTrue() {
        pooYaGhost.decreaseHp(10);
        assertTrue(pooYaGhost.isDestroyed());
    }

    @Test
    void testGetHp() {
        assertEquals(10, pooYaGhost.getHp());
    }

    @Test
    void testDecreaseHp() {
        pooYaGhost.decreaseHp(3);
        assertEquals(7, pooYaGhost.getHp());
    }

    @Test
    void testDecreaseHpBelowZero() {
        pooYaGhost.decreaseHp(15);
        assertEquals(0, pooYaGhost.getHp());
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20);
        GameController.getInstance().setScore(15);
        pooYaGhost.attack();
        assertEquals(18, GameController.getInstance().getHp());
        assertEquals(13, GameController.getInstance().getScore());
    }


    @Test
    void testToString() {
        assertEquals("PooYaGhost [HP: 10 , Power: 2]", pooYaGhost.toString());
    }

    @Test
    void testDamage() {
        // TODO: Fill your code
        GameController controller = GameController.getInstance();
        PooYaGhost pooYaGhost1 = new PooYaGhost(9);

        controller.getGhosts().clear();
        for (int i = 0; i < 3; ++i) controller.getGhosts().add(GameUtils.getRandomGhost(false));

        controller.getGhosts().add(pooYaGhost1);
        pooYaGhost1.damage();

        assertEquals(12, controller.getGhosts().get(0).getHp());
        assertEquals(12, controller.getGhosts().get(1).getHp());
        assertEquals(12, controller.getGhosts().get(2).getHp());

    }

}