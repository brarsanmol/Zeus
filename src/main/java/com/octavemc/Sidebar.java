package com.octavemc;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;

import java.util.stream.IntStream;

@Getter
public class Sidebar {

    private final Player player;
    private final Scoreboard scoreboard;

    public Sidebar(@NonNull Player player) {
        this.player = player;
        this.scoreboard = Zeus.getInstance().getPlugin().getServer().getScoreboardManager().getNewScoreboard();
        this.scoreboard.registerNewObjective("zeus", "dummy");
        this.scoreboard.getObjective("zeus").setDisplaySlot(DisplaySlot.SIDEBAR);
        this.scoreboard.getObjective("zeus").setDisplayName(Zeus.getInstance().getSidebarAdapter().getTitle());
        IntStream.range(0, 15).forEach(number -> this.scoreboard.registerNewTeam("zeus" + number).addEntry(Zeus.getInstance().getSidebarEntryGenerator().getNextEntry(number)));
        this.player.setScoreboard(this.scoreboard);
    }

}