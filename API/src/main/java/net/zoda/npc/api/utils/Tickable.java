package net.zoda.npc.api.utils;

import net.zoda.npc.api.NPCAdapter;

import java.util.Set;

@FunctionalInterface
public interface Tickable extends Runnable {
    void tick();
    default Set<ChildTickable> children() { return Set.of(); };

    /**
     * In-case a runnable needs to be used...
     */
    @Override
    default void run() { tick(); }

    default void cancel(NPCAdapter adapter) {
        adapter.unregisterTickable(this);
    }

}
