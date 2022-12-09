package net.zoda.npc.impl.bukkit.utils.packets.connection;

import net.zoda.npc.impl.bukkit.utils.packets.bridge.NMSBridge;
import net.zoda.npc.impl.bukkit.utils.packets.connection.packets.ConvertedPacket;

public interface PlayerConnection {

    NMSBridge bridge();
    void sendPacket(ConvertedPacket packet);

}
