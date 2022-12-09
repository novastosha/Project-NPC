package net.zoda.npc.api;

import net.zoda.npc.api.utils.Tickable;

/**
 * Represents the platform
 *
 * @see NPC
 * @see NPCEntity
 */
public interface NPCAdapter {


    /**
     * Register a tickable and its children
     *
     * @param tickable the tickable object
     */
    void registerTickable(Tickable tickable);

    /**
     * Unregister a tickable
     *
     * @implNote if the tickable object is not an instance of {@link net.zoda.npc.api.utils.ChildTickable} and has children, unregister those too.
     * @param tickable the tickable object
     */
    void unregisterTickable(Tickable tickable);

}
