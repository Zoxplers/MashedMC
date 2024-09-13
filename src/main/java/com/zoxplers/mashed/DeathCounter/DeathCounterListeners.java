package com.zoxplers.mashed.DeathCounter;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class DeathCounterListeners implements Listener
{
    //Variables
    HashMap<UUID, Integer> data;

    //Constructor
    public DeathCounterListeners()
    {
        data = DeathCounter.loadData();
    }

    //Functions
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        int deaths = data.getOrDefault(player.getUniqueId(), 0);
        data.put(player.getUniqueId(), ++deaths);
        DeathCounter.saveData(data);
        MashedMC.getInstance().getServer().broadcastMessage(MashedMC.translate(MashedMC.SECONDARY + player.getDisplayName() + MashedMC.PRIMARY + " now has " + MashedMC.SECONDARY + deaths + MashedMC.PRIMARY + " deaths."));
    }
}