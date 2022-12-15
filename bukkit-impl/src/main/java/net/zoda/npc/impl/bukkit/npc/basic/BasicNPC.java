package net.zoda.npc.impl.bukkit.npc.basic;

import lombok.Getter;
import net.zoda.nms.bridge.NMSBridge;
import net.zoda.nms.bridge.entity.FakeEntityReference;
import net.zoda.npc.api.position.Position;
import net.zoda.npc.impl.bukkit.npc.BukkitNPC;
import net.zoda.npc.impl.bukkit.platform.PluginBukkitPlatform;
import net.zoda.npc.impl.bukkit.viewer.BukkitNPCViewer;
import net.zoda.npc.impl.bukkit.world.BukkitWorld;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class BasicNPC extends BukkitNPC {
    private static final NMSBridge bridge = NMSBridge.get();

    @Getter private final EntityType type;
    private final FakeEntityReference fakeEntityReference;

    private Position position;

    public BasicNPC(Position position, EntityType type, World world, Plugin plugin) {
        super(BukkitWorld.of(world), PluginBukkitPlatform.of(plugin));

        assert type.isSpawnable() : "EntityType is not spawnable!";

        this.type = type;
        this.position = position;

        this.fakeEntityReference = bridge.createFakeEntity(position,type);
    }

    @Override
    public int entityID() {
        return fakeEntityReference.entityID();
    }

    @Override
    public Position position() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        fakeEntityReference.updatePosition(position);
    }

    @Override
    public void refresh() {

    }

    @Override
    protected void addViewer(BukkitNPCViewer viewer) {
        if(viewer.getPlayer() == null) {
            viewers.remove(viewer);
            return;
        }

        fakeEntityReference.addViewer(viewer.getPlayer());
    }

    @Override
    protected void removeViewer(BukkitNPCViewer viewer) {
        if(viewer.getPlayer() != null) {
            fakeEntityReference.removeViewer(viewer.getPlayer());
        }
    }

}
