package net.zoda.npc.api.world;

import net.zoda.npc.api.NPCAdapter;
import net.zoda.npc.api.NPCEntity;
import net.zoda.npc.api.world.entity.OtherEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public interface NPCWorld<T extends NPCAdapter> {

    String getName();
    @Nullable String getNamespace();

    UUID getUID();

    Set<OtherEntity<T>> getEntities();

    void killEntity(OtherEntity<T> entity);

    void spawnEntity(OtherEntity<T> entity);
}
