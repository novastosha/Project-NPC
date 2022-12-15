package net.zoda.npc.api.world.entity;

import net.zoda.npc.api.platform.Platform;

import java.util.UUID;

public interface PlayerWorldEntity<P extends Platform> extends WorldEntity<P> {

    UUID getUniqueId();

}
