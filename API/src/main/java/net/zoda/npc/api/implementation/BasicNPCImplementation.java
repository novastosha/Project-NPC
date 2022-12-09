package net.zoda.npc.api.implementation;

import net.zoda.npc.api.NPCAdapter;

public abstract class BasicNPCImplementation<T extends NPCAdapter> implements NPCImplementation<T> {

    public abstract void clearAI();

}
