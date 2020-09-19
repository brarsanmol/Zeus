package com.octavemc;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

@Getter(AccessLevel.PROTECTED)
public final class Zeus {

    @Getter
    private static Zeus instance;
    private final JavaPlugin plugin;
    private final SidebarAdapter sidebarAdapter;
    private final SidebarEntryGenerator sidebarEntryGenerator;
    private final SidebarManager sidebarManager;
    private final SidebarTask sidebarTask;

    public Zeus(@NonNull JavaPlugin plugin, @NonNull SidebarAdapter sidebarAdapter) {
        instance = this;
        this.plugin = plugin;
        this.sidebarAdapter = sidebarAdapter;
        this.sidebarEntryGenerator = new SidebarEntryGenerator();
        this.sidebarManager = new SidebarManager();
        this.sidebarTask = new SidebarTask();
        new SidebarListener();
    }

}
