package net.zoda.npc.impl.bukkit.viewer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.api.NPC;
import net.zoda.npc.api.position.Position;
import net.zoda.npc.api.viewer.NPCViewer;
import net.zoda.npc.api.world.World;
import net.zoda.npc.impl.bukkit.npc.BukkitNPC;
import net.zoda.npc.impl.bukkit.platform.PluginBukkitPlatform;
import net.zoda.npc.impl.bukkit.utils.PositionUtils;
import net.zoda.npc.impl.bukkit.world.BukkitWorld;
import org.bukkit.entity.Player;

import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BukkitNPCViewer implements NPCViewer<PluginBukkitPlatform> {

    public static BukkitNPCViewer of(BukkitNPC npc, Player player) {
        return new BukkitNPCViewer(player, npc);
    }

    @Getter
    private final Player player;
    private final BukkitNPC npc;

    @Override
    public NPC<PluginBukkitPlatform> viewingNPC() {
        return npc;
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public int entityID() {
        return player.getEntityId();
    }

    @Override
    public World<PluginBukkitPlatform> world() {
        return BukkitWorld.of(player.getWorld());
    }

    @Override
    public Position position() {
        return PositionUtils.toPosition(player.getLocation());
    }
}
