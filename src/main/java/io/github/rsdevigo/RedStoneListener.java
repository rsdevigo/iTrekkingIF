package io.github.rsdevigo;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.Bukkit;

public final class RedStoneListener implements Listener {
    @EventHandler
    public void changeControlPoint(BlockRedstoneEvent event) {
      int state = event.getNewCurrent();
      Bukkit.getServer().broadcastMessage("RedStone está");
        // Pega o x,y,z do ponto de controle para definir qual ponto de controle foi acionado
        // Pega o estado atual do ponto de controle
        // Pega o jogador ou id do jogador
        // Busca no mysql se o jogador já tem aquele ponto de controle
        // Salva no mysql usando o bukkit (x, y, z, nome do ponto de controle, id do jogador, timestamp, ) se o jogador não tiver o ponto de controle
        // Libera achievement pro jogador visualizar que ele atingiu o ponto de controle
        // Atualiza o estado da redstone para false novamente
    }
}