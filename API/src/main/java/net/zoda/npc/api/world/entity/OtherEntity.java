package net.zoda.npc.api.world.entity;

import net.zoda.npc.api.NPCAdapter;
import net.zoda.npc.api.utils.Location;
import net.zoda.npc.api.world.NPCWorld;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface OtherEntity<T extends NPCAdapter> {

    int getEntityId();
    @Nullable UUID getUUID();

    boolean isTileEntity();

    void onKill(NPCWorld<T> world);

    Location location();
    void location(Location location);

}
