package net.zoda.nms.bridge.entity;

import net.zoda.nms.bridge.NMSBridge;
import net.zoda.nms.bridge.entity.player.FakePlayerEntityReference;
import net.zoda.npc.api.position.Position;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;

import java.util.Set;

public interface FakeEntityReference {

    Object NMSEntity();

    @ApiStatus.Internal
    Object spawnPacket();

    int entityID();

    NMSBridge bridge();

    void addViewer(Player player);

    void removeViewer(Player player);

    Set<Player> viewers();

    void updatePosition(Position position);
}
