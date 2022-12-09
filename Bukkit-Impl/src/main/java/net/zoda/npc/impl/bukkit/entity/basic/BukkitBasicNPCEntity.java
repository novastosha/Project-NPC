package net.zoda.npc.impl.bukkit.entity.basic;

import net.zoda.npc.api.NPCEntity;
import net.zoda.npc.api.utils.Location;
import net.zoda.npc.api.world.NPCWorld;
import net.zoda.npc.impl.bukkit.PluginBukkitNPCAdapter;
import net.zoda.npc.impl.bukkit.entity.BukkitNPCEntity;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class BukkitBasicNPCEntity implements BukkitNPCEntity {
    @Override
    public PluginBukkitNPCAdapter getPlatform() {
        return null;
    }

    @Override
    public boolean spawn() {
        return false;
    }

    @Override
    public boolean hasSpawned() {
        return false;
    }

    @Override
    public NPCWorld<PluginBukkitNPCAdapter> world() {
        return null;
    }

    @Override
    public void despawnForcibly() {

    }

    @Override
    public int getEntityId() {
        return 0;
    }

    @Override
    public @Nullable UUID getUUID() {
        return null;
    }

    @Override
    public void onKill(NPCWorld<PluginBukkitNPCAdapter> world) {

    }

    @Override
    public Location location() {
        return null;
    }

    @Override
    public void location(Location location) {

    }
}
