package net.zoda.npc.impl.bukkit.utils;

import lombok.experimental.UtilityClass;
import net.zoda.npc.api.position.Position;
import org.bukkit.Location;

@UtilityClass
public class PositionUtils {

    public Position toPosition(Location location) {
        return new Position(location.getX(),location.getY(),location.getZ(),location.getYaw(),location.getPitch());
    }

    public Location fromPosition(Position position) {
        return new Location(null,position.getX(),position.getY(),position.getZ(),position.getYaw(),position.getPitch());
    }

}
