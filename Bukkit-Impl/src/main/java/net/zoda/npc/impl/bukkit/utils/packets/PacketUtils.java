package net.zoda.npc.impl.bukkit.utils.packets;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.zoda.npc.impl.bukkit.utils.packets.bridge.NMSBridge;
import net.zoda.npc.impl.bukkit.utils.packets.connection.PlayerConnection;
import org.bukkit.entity.Player;

@UtilityClass
public class PacketUtils {
    @Getter private final NMSBridge bridge = ServerVersion.get().construct();
}
