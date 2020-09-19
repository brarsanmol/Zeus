package com.octavemc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;

public final class SidebarListener implements Listener {

    protected SidebarListener() {
        Zeus.getInstance().getPlugin().getServer().getPluginManager().registerEvents(this, Zeus.getInstance().getPlugin());
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Zeus.getInstance().getSidebarManager().getSidebars().putIfAbsent(event.getPlayer().getUniqueId(), new Sidebar(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        event.getPlayer().getScoreboard().getTeams().forEach(team -> team.unregister());
        event.getPlayer().getScoreboard().getObjectives().forEach(objective -> objective.unregister());
        Zeus.getInstance().getSidebarManager().getSidebars().remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPluginDisableEvent(PluginDisableEvent event) {
        if (!event.getPlugin().equals(this)) return;
        Zeus.getInstance().getSidebarEntryGenerator().clearEntries();
        Zeus.getInstance().getSidebarTask().cancel();
    }

}