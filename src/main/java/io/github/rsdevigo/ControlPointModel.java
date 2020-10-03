package io.github.rsdevigo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import java.util.List;
import java.util.Map;

class ControlPointModel {

    public static ControlPoint getControlPoint(int x, int y, int z) {

        String response = HttpRequest.get("http://localhost:1337/ponto-de-controles?x=" + Integer.toString(x) + "&y="
                + Integer.toString(y) + "&z=" + Integer.toString(z) + "&_limit=1").body();
        ObjectMapper objm = new ObjectMapper();
        try {
            List<Map<?, ?>> cpa = objm.readValue(response, new TypeReference<List<Map<?, ?>>>() {
            });
            int i;
            for (i = 0; i < cpa.size(); i++) {
                Map<?, ?> controlPointMap = cpa.get(i);
                ControlPoint cp = new ControlPoint();
                cp.setId((int) controlPointMap.get((String) "id"));
                cp.setX((int) controlPointMap.get((String) "x"));
                cp.setY((int) controlPointMap.get((String) "y"));
                cp.setZ((int) controlPointMap.get((String) "z"));
                cp.setNome((String) controlPointMap.get((String) "nome"));
                System.out.println(cp.getId());
                System.out.println(cp.getNome());
                System.out.println(cp.getX());
                System.out.println(cp.getY());
                System.out.println(cp.getZ());
                return cp;
            }

            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}