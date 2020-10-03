package io.github.rsdevigo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;

class PlayerControlPointModel {

    public static boolean create(String uuid, int point_id, String player_name, long when) {
        Map<String, Object> playerControlPointOBJ = new HashMap<String, Object>();
        playerControlPointOBJ.put("nome", (String) player_name);
        playerControlPointOBJ.put("uuid", (String) uuid);
        playerControlPointOBJ.put("ponto_de_controle", (int) point_id);
        playerControlPointOBJ.put("when", (long) when);
        System.out.println(playerControlPointOBJ);
        ObjectMapper objm = new ObjectMapper();
        try {
            String playerControlPointJSON = objm.writeValueAsString(playerControlPointOBJ);
            int response = HttpRequest.post("http://localhost:1337/jogador-e-ponto-de-controles")
                    .header("Content-Type", "application/json").send(playerControlPointJSON).code();
            System.out.println(response);
            if (response == 200) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static PlayerControlPoint findByPlayer(String uuid, int point_id) {

        String response = HttpRequest.get("http://localhost:1337/jogador-e-ponto-de-controles?uuid=" + uuid
                + "&ponto_de_controle.id=" + Integer.toString(point_id) + "&_limit=1").body();
        ObjectMapper objm = new ObjectMapper();
        System.out.println(response);
        try {
            List<Map<?, ?>> pcpa = objm.readValue(response, new TypeReference<List<Map<?, ?>>>() {
            });
            int i;
            for (i = 0; i < pcpa.size(); i++) {
                Map<?, ?> playerControlPointMap = pcpa.get(i);
                Map<?, ?> ponto_controle = (Map<?, ?>) playerControlPointMap.get("ponto_de_controle");
                PlayerControlPoint pcp = new PlayerControlPoint();
                pcp.setId((int) playerControlPointMap.get("id"));
                pcp.player_uuid = (String) playerControlPointMap.get("uuid");
                pcp.player_name = (String) playerControlPointMap.get("nome");
                pcp.point_name = (String) ponto_controle.get("nome");
                pcp.point_id = (int) ponto_controle.get("id");
                pcp.x = (int) ponto_controle.get("x");
                pcp.y = (int) ponto_controle.get("y");
                pcp.z = (int) ponto_controle.get("z");

                System.out.println(pcp.id);
                System.out.println(pcp.x);
                System.out.println(pcp.y);
                System.out.println(pcp.z);
                System.out.println(pcp.point_name);
                System.out.println(pcp.point_id);
                System.out.println(pcp.player_uuid);
                System.out.println(pcp.player_name);

                return pcp;
            }

            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}