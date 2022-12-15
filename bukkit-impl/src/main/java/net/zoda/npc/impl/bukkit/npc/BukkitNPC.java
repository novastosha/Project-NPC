package net.zoda.npc.impl.bukkit.npc;

import net.zoda.npc.api.NPC;
import net.zoda.npc.api.nametag.NameLine;
import net.zoda.npc.api.viewer.NPCViewer;
import net.zoda.npc.api.world.World;
import net.zoda.npc.impl.bukkit.platform.PluginBukkitPlatform;
import net.zoda.npc.impl.bukkit.viewer.BukkitNPCViewer;
import net.zoda.npc.impl.bukkit.world.BukkitWorld;

import java.util.ArrayList;
import java.util.Set;

public abstract class BukkitNPC implements NPC<PluginBukkitPlatform> {

    private final BukkitWorld world;
    private final PluginBukkitPlatform platform;

    protected final ArrayList<NPCViewer<PluginBukkitPlatform>> viewers;
    private NameLine[] tag;

    protected BukkitNPC(BukkitWorld world,PluginBukkitPlatform platform) {
        this.world = world;
        this.platform = platform;
        
        this.viewers = new ArrayList<>();
        
        this.tag = new NameLine[0];
    }

    @Override
    public final Set<NPCViewer<PluginBukkitPlatform>> viewers() {
        return Set.copyOf(viewers);
    }

    @Override
    public final void addViewer(NPCViewer<PluginBukkitPlatform> viewer) {
        assert viewer instanceof BukkitNPCViewer: "Viewer is not of type: "+BukkitNPCViewer.class.getSimpleName();
        viewers.add(viewer);

        addViewer((BukkitNPCViewer) viewer);
    }

    @Override
    public final void removeViewer(NPCViewer<PluginBukkitPlatform> viewer) {
        assert viewer instanceof BukkitNPCViewer: "Viewer is not of type: "+BukkitNPCViewer.class.getSimpleName();
        if(!viewers.contains(viewer)) return;

        viewers.remove(viewer);
        removeViewer((BukkitNPCViewer) viewer);
    }

    @Override
    public final World<PluginBukkitPlatform> world() {
        return world;
    }

    @Override
    public final PluginBukkitPlatform platform() {
        return platform;
    }

    protected abstract void addViewer(BukkitNPCViewer viewer);
    protected abstract void removeViewer(BukkitNPCViewer viewer);

    @Override
    public final NameLine[] nameTag() {
        return tag;
    }

    @Override
    public final void setNameTag(NameLine[] lines) {
        this.tag = lines;
    }

}
