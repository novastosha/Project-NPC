package net.zoda.npc.impl.bukkit.utils.packets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.zoda.npc.impl.bukkit.utils.Pair;
import net.zoda.npc.impl.bukkit.utils.packets.bridge.NMSBridge;
import net.zoda.npc.impl.bukkit.wrapper.v1_19_R1NMSBridge;
import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

public enum ServerVersion {

    v1_19_R1() {
        @Override
        public NMSBridge construct() {
            return new v1_19_R1NMSBridge();
        }
    };

    private static final Logger logger = Logger.getLogger("ProjectNPC-Bukkit Server Version");

    public abstract NMSBridge construct();

    public static ServerVersion get() {
        final String versionString = getServerVersionString(Bukkit.getServer());

        try {
            return valueOf(versionString);
        }catch (IllegalArgumentException exception) {
            throw new UnsupportedOperationException("This server version (MC: "+versionString+") is not supported!");
        }
    }

    public static String getServerVersionString(Server server) {
        return server.getClass().getPackage().getName().split("\\.")[3];
    }
}
