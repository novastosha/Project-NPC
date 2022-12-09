package net.zoda.npc.impl.bukkit;

import net.zoda.npc.api.NPCAdapter;
import net.zoda.npc.api.utils.ChildTickable;
import net.zoda.npc.api.utils.Tickable;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public final class PluginBukkitNPCAdapter implements NPCAdapter {

    private final Server server;
    private final Plugin plugin;

    private final Map<Tickable, Integer> taskIDs;

    public PluginBukkitNPCAdapter(Plugin plugin) {
        this.server = plugin.getServer();
        this.plugin = plugin;
        this.taskIDs = new HashMap<>();
    }

    @Override
    public void registerTickable(Tickable tickable) {
        if(!(tickable instanceof ChildTickable) && taskIDs.containsKey(tickable)) return;

        taskIDs.put(tickable,server.getScheduler().scheduleSyncRepeatingTask(plugin,tickable,0,0));
        tickable.children().forEach(this::registerTickable);
    }

    @Override
    public void unregisterTickable(Tickable tickable) {
        if(!taskIDs.containsKey(tickable)) return;

        server.getScheduler().cancelTask(taskIDs.get(tickable));
        tickable.children().forEach(this::unregisterTickable);
    }
}
