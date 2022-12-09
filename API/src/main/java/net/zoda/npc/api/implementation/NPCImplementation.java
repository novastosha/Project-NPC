package net.zoda.npc.api.implementation;

import net.zoda.npc.api.NPC;
import net.zoda.npc.api.NPCAdapter;
import net.zoda.npc.api.utils.Tickable;


public interface NPCImplementation<T extends NPCAdapter> extends Tickable {

    NPC<T> getNPC();

}
