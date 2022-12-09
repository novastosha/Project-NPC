package net.zoda.npc.api;

import net.zoda.npc.api.world.NPCWorld;
import net.zoda.npc.api.world.entity.OtherEntity;

import java.util.UUID;

public interface NPCEntity<T extends NPCAdapter> extends OtherEntity<T> {
    T getPlatform();

    boolean spawn();

    boolean hasSpawned();

    NPCWorld<T> world();

    void despawnForcibly();

    @Override
    default boolean isTileEntity() {
        return false;
    }

    default boolean isClientSide() {
        return true;
    }
}
