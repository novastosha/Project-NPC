package net.zoda.nms.scoreboard;

import net.zoda.nms.bridge.entity.FakeEntityReference;
import net.zoda.nms.bridge.entity.player.FakePlayerEntityReference;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public interface ScoreboardTeam {

    void create(Player player);

    FakePlayerEntityReference[] players();

    void addPlayer(FakeEntityReference reference);

    void destroyTeam();
}
