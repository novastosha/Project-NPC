package net.zoda.npc.impl.bukkit.plugin;

import lombok.Getter;
import net.zoda.npc.api.nametag.NameLine;
import net.zoda.npc.api.position.Position;
import net.zoda.npc.impl.bukkit.npc.basic.BasicNPC;
import net.zoda.npc.impl.bukkit.viewer.BukkitNPCViewer;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectNPCBukkitPlugin extends JavaPlugin {
    @Getter private static ProjectNPCBukkitPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        BasicNPC npc = new BasicNPC(new Position(0,0,0), EntityType.BLAZE, getServer().getWorld("world"), this);
        npc.setNameTag(new NameLine[]{
                new NameLine("Hello, how are you?")
        });

        npc.addViewer(BukkitNPCViewer.of(npc, Bukkit.getPlayer("vugy")));
    }
}
