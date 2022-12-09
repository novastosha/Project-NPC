package net.zoda.npc.api.trait;

import net.zoda.npc.api.NPC;
import net.zoda.npc.api.NPCAdapter;
import net.zoda.npc.api.implementation.NPCImplementation;

/**
 * This is different from {@link NPCImplementation} as an NPC can have multiple traits but a single implementation
 *
 * @param <T> the target platform
 */
public interface ITrait<T extends NPCAdapter> {

    void refresh(NPC<T> npc);

    void tick(NPC<T> npc);

}
