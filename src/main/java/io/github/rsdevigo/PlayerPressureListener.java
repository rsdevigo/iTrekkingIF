package io.github.rsdevigo;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;

public final class PlayerPressureListener implements Listener {
    @EventHandler
    public void changeControlPoint(PlayerInteractEvent event) {
      Action state = event.getAction();
      if (state == Action.PHYSICAL)
      {
        Block block = event.getClickedBlock();
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        // Busca o Ponto de Controle
        ControlPoint cp = ControlPointModel.getControlPoint(x, y, z);
        if (cp != null) {
          
          UUID playerId = event.getPlayer().getUniqueId();
          PlayerControlPoint pcp = PlayerControlPointModel.findByPlayer(playerId.toString(), cp.getId());
          if (pcp == null) {
            String playerName = event.getPlayer().getDisplayName();
            if (PlayerControlPointModel.create(playerId.toString(), cp.getId(), cp.getName(), x, y, z, playerName)) {
              Bukkit.getServer().broadcastMessage(playerName + " ativou o "+ cp.getName());
            }
          }
          // Busca no mysql se o jogador já tem aquele ponto de controle
          // Salva no mysql usando o bukkit (x, y, z, nome do ponto de controle, id do jogador, timestamp, ) se o jogador não tiver o ponto de controle
        }
      }
    }
}