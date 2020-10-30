package ohtuesimerkki;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    List<Player> pelaajat;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
        pelaajat = readerStub.getPlayers();
    }

    @Test
    public void searchKunLoytyy() {
        assertEquals(pelaajat.get(0), stats.search("Semenko"));
    }

    @Test
    public void searchKunEiLoydy() {
        assertEquals(null, stats.search("Pelaaja"));
    }

    @Test
    public void teamLoytyy() {
        ArrayList<Player> edmPelaajat = new ArrayList<>();
        edmPelaajat.add(pelaajat.get(0));
        edmPelaajat.add(pelaajat.get(2));
        edmPelaajat.add(pelaajat.get(4));

        assertEquals(edmPelaajat, stats.team("EDM"));
    }

    @Test
    public void topScorersLoytyy() {
        ArrayList<Player> top = new ArrayList<>();
        top.add(pelaajat.get(4));
        top.add(pelaajat.get(1));

        assertEquals(top, stats.topScorers(1));
    }

}
