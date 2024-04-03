package handball;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTests {

    private Team team;
    private HandballPlayer player1;
    private HandballPlayer player2;
    private HandballPlayer player3;

    @Before
    public void setUp() {
        team = new Team("Team A", 5);
        player1 = new HandballPlayer("John");
        player2 = new HandballPlayer("Alice");
        player3 = new HandballPlayer("Bob");
    }

    @Test
    public void testAddPlayer() {
        team.add(player1);
        assertEquals(1, team.getCount());
    }

    @Test
    public void testRemovePlayer() {
        team.add(player1);
        team.add(player2);
        team.remove("John");
        assertEquals(1, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePlayerNotInTeam() {
        team.remove("Unknown");
    }



    @Test(expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamNotInTeam() {
        team.playerForAnotherTeam("Unknown");
    }



    @Test(expected = NullPointerException.class)
    public void testNameCannotBeNull() {
        new Team(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testNameCannotBeEmpty() {
        new Team("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPositionCannotBeNegative() {
        new Team("Team A", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTeamIsFull() {
        team.add(player1);
        team.add(player2);
        team.add(player3);
        team.add(new HandballPlayer("Charlie"));
        team.add(new HandballPlayer("David"));
        team.add(new HandballPlayer("Eve"));
    }
    @Test
    public void testConstructor() {
        HandballPlayer player = new HandballPlayer("John");
        assertEquals("John", player.getName());
        assertTrue(player.isActive());
    }

    @Test
    public void testSetActive() {
        HandballPlayer player = new HandballPlayer("John");
        player.setActive(false);
        assertFalse(player.isActive());
    }

}
