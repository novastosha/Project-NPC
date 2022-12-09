package net.zoda.npc.impl.bukkit.plugin;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectNPCBukkitPlugin extends JavaPlugin {
    @Getter private static ProjectNPCBukkitPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        test();
    }

    public void test() {

    }
}
