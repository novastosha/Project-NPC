package net.zoda.npc.impl.bukkit.wrapper;

import net.zoda.npc.impl.bukkit.utils.packets.bridge.NMSBridge;
import net.zoda.npc.impl.bukkit.utils.packets.connection.PlayerConnection;
import net.zoda.npc.impl.bukkit.utils.packets.connection.packets.ConvertedPacket;
import org.bukkit.entity.Player;

public final class v1_19_R1NMSBridge implements NMSBridge {


    @Override
    public PlayerConnection getConnection(Player player) {
        return new PlayerConnection() {


            @Override
            public NMSBridge bridge() {
                return v1_19_R1NMSBridge.this;
            }

            @Override
            public void sendPacket(ConvertedPacket packet) {

            }
        };
    }
}
