package ca.anmolbrar;

import org.bukkit.entity.Player;

import java.util.List;

public interface SidebarAdapter {

    String getTitle();

    List<String> getLines(Player player);

    default long getUpdateDelay() {
        return 20L;
    }

}