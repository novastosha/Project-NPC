package net.zoda.npc.api.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public sealed class Location permits Location.RotationalLocation {
    @Getter private final double x,y,z;


    public static final class RotationalLocation extends Location {

        @Getter private final float yaw,pitch;

        public RotationalLocation(double x, double y, double z,
                                  float yaw, float pitch) {
            super(x, y, z);
            this.yaw = yaw;
            this.pitch = pitch;
        }
    }

    public float getYaw() {
        return (this instanceof RotationalLocation loc) ? loc.yaw : 0;
    }

    public float getPitch() {
        return (this instanceof RotationalLocation loc) ? loc.pitch : 0;
    }

}