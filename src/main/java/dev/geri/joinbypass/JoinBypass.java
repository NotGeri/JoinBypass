package dev.geri.joinbypass;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinBypass extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent e) {
        if (e.getResult() != PlayerLoginEvent.Result.KICK_FULL) return;
        if (!e.getPlayer().hasPermission("joinbypass.use")) return;

        // Otherwise allow
        e.allow();
    }

}
