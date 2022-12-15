package net.zoda.npc.api.viewer;

import net.zoda.npc.api.NPC;
import net.zoda.npc.api.platform.Platform;
import net.zoda.npc.api.world.entity.PlayerWorldEntity;

public interface NPCViewer<P extends Platform> extends PlayerWorldEntity<P> {
    NPC<P> viewingNPC();
}
