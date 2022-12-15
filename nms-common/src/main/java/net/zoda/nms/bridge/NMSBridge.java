package net.zoda.nms.bridge;

import net.zoda.nms.bridge.entity.FakeEntityReference;
import net.zoda.nms.bridge.entity.player.FakePlayerData;
import net.zoda.nms.bridge.entity.player.FakePlayerEntityReference;
import net.zoda.nms.scoreboard.ScoreboardTeam;
import net.zoda.npc.api.position.Position;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

public interface NMSBridge {

    static NMSBridge get() {
        final String versionString = getServerVersionString(Bukkit.getServer());

        try {
            return (NMSBridge) Class.forName("net.zoda.nms.bridges."+versionString+"."+versionString+"NMSBridge").getConstructor().newInstance();
        } catch (ClassNotFoundException exception) {
            throw new UnsupportedOperationException("This server version (MC: " + versionString + ") is not supported!");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    static String getServerVersionString(Server server) {
        return server.getClass().getPackage().getName().split("\\.")[3];
    }

    FakePlayerEntityReference createFakePlayerEntity(Position position, FakePlayerData data, Player... players);
    FakeEntityReference createFakeEntity(net.zoda.npc.api.position.Position position, EntityType type);


    void spawnFakeEntityFor(FakeEntityReference reference,Player[] players);
    void despawnFakeEntity(FakeEntityReference entityReference, Player... players);

    ScoreboardTeam nameHidingTeam();

}
