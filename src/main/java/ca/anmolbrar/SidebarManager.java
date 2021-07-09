package ca.anmolbrar;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class SidebarManager {

    @Getter
    private final Map<UUID, Sidebar> sidebars;

    protected SidebarManager() {
        this.sidebars = new HashMap<>();
    }

    public Optional<Sidebar> getSidebar(@NonNull Player target) {
        return Optional.ofNullable(this.sidebars.get(target.getUniqueId()));
    }

}