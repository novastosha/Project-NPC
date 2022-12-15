package net.zoda.npc.api.world.entity;

import net.zoda.npc.api.platform.Platform;
import net.zoda.npc.api.position.Position;
import net.zoda.npc.api.world.World;

public interface WorldEntity<P extends Platform> {

    int entityID();

    World<P> world();
    Position position();
}
