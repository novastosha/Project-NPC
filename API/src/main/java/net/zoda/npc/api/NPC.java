package net.zoda.npc.api;

import net.zoda.npc.api.nametag.NameLine;
import net.zoda.npc.api.platform.Platform;
import net.zoda.npc.api.position.Position;
import net.zoda.npc.api.viewer.NPCViewer;
import net.zoda.npc.api.world.entity.WorldEntity;

import java.util.Set;
import java.util.function.Function;

public interface NPC<P extends Platform> extends WorldEntity<P> {

    Platform platform();

    void refresh();

    void setPosition(Position position);


    Set<NPCViewer<P>> viewers();
    void addViewer(NPCViewer<P> viewer);
    void removeViewer(NPCViewer<P> viewer);

    NameLine[] nameTag();
    void setNameTag(NameLine[] lines);
}
