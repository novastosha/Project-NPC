package net.zoda.npc.impl.bukkit.utils.packets.bridge;

import net.zoda.npc.impl.bukkit.utils.packets.connection.PlayerConnection;
import org.bukkit.entity.Player;

public interface NMSBridge {

    PlayerConnection getConnection(Player player);

}
