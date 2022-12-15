package net.zoda.nms.bridge.entity.player;

import net.zoda.nms.bridge.entity.FakeEntityReference;
import net.zoda.nms.bridge.entity.player.FakePlayerData;
import net.zoda.nms.scoreboard.ScoreboardTeam;

public interface FakePlayerEntityReference extends FakeEntityReference {

    FakePlayerData data();

    Object infoPacket();

    ScoreboardTeam team();

}
