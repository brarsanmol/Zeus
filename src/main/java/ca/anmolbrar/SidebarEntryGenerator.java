package ca.anmolbrar;

import com.google.common.base.Preconditions;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class SidebarEntryGenerator {

    private final List<String> entries;

    protected SidebarEntryGenerator() {
        this.entries = new ArrayList<>();
        IntStream.range(0, ChatColor.values().length).forEach(index -> this.entries.add(ChatColor.values()[index] + "" + ChatColor.values()[index] + ChatColor.RESET));
    }

    protected String getNextEntry(int index) {
        Preconditions.checkArgument(index > -1, "Index cannot be negative.");
        Preconditions.checkArgument(index < ChatColor.values().length, "Index cannot greater than " + ChatColor.values().length + ".");
        return this.entries.get(index);
    }

    protected void clearEntries() {
        this.entries.clear();
    }

}