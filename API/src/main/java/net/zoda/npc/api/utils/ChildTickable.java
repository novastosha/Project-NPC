package net.zoda.npc.api.utils;

public interface ChildTickable extends Tickable {
    Tickable parent();

}
