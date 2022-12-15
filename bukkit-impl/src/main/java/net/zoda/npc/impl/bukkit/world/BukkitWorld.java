package net.zoda.npc.impl.bukkit.world;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.api.world.World;
import net.zoda.npc.impl.bukkit.platform.PluginBukkitPlatform;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class BukkitWorld implements World<PluginBukkitPlatform> {

    public static BukkitWorld of(org.bukkit.World world) {
        return new BukkitWorld(world);
    }

    private final org.bukkit.World bukkitWorld;

}
