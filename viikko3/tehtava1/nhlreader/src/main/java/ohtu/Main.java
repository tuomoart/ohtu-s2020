package ohtu;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        List<Player> suomiPojad = new ArrayList();

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                suomiPojad.add(player);
            }
        }
        
        Collections.sort(suomiPojad);

        System.out.println(suomiPojad);
    }
  
}