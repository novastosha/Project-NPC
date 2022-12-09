package net.zoda.npc.api;

import net.zoda.npc.api.implementation.NPCImplementation;
import net.zoda.npc.api.stats.NPCStats;
import net.zoda.npc.api.trait.ITrait;
import net.zoda.npc.api.utils.Tickable;
import net.zoda.npc.api.viewer.Viewer;

import java.util.Set;

/**
 * Represents a wrapped entity on a platform with traits and implementation
 *
 * @param <T> the target platform
 *
 * @see NPCImplementation
 * @see Viewer
 * @see NPC#refresh()
 */
public interface NPC<T extends NPCAdapter,E extends NPCEntity<T>> extends Tickable {

    /**
     * @return the current implementation of the NPC
     *
     * @see ITrait
     */
    NPCImplementation<T> implementation();
    void implementation(NPCImplementation<T> implementation);

    Set<ITrait<T>> traits();

    void addTrait();
    void removeTrait();

    E entity();
    NPCStats stats();

    /**
     * Refreshes the NPC (aka. update skin, traits and entity)
     */
    void refresh();

    /**
     *
     * @return current viewers of the NPC (this doesn't mean they actually see the NPC in-game, they just have the ability to do so...)
     */
    Set<Viewer<T>> getViewers();

    /**
     * @apiNote if the supplied viewer is already present in {@link NPC#getViewers()} the call will be ignored!
     *
     * @param viewer the viewer
     */
    void addViewer(Viewer<T> viewer);

    /**
     * @apiNote If the supplied viewer is not present in {@link NPC#getViewers()} the call will be ignored!
     *
     * @param viewer the viewer
     */
    void removeViewer(Viewer<T> viewer);

    @Override
    default void tick() {
        traits().forEach(trait -> trait.tick(this));

    }
}
