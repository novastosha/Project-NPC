package net.zoda.npc.impl.bukkit.platform;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.api.platform.Platform;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class PluginBukkitPlatform implements Platform {

    public static PluginBukkitPlatform of(Plugin plugin) {
        return new PluginBukkitPlatform(plugin);
    }

    @Getter private final Plugin plugin;

    @Override
    public final String getName() {
        return "Bukkit";
    }
}
