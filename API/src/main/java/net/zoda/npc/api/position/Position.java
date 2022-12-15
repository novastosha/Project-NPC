package net.zoda.npc.api.position;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Position {

    @Getter private final double x,y,z;
    @Getter private final float yaw,pitch;

    public Position(double x, double y, double z) {
        this(x,y,z,0F,0F);
    }
}
