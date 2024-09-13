package com.zoxplers.mashed.DeathCoordinates;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener
{
    //Functions
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        Location eyeLocation = player.getEyeLocation();

        player.sendMessage(MashedMC.translate(MashedMC.PRIMARY + "You died at X = " + MashedMC.SECONDARY + eyeLocation.getBlockX() + MashedMC.PRIMARY + ", Y = " + MashedMC.SECONDARY + eyeLocation.getBlockY() + MashedMC.PRIMARY + ", Z = " + MashedMC.SECONDARY + eyeLocation.getBlockZ()));
        MashedMC.log(MashedMC.translate(MashedMC.SECONDARY + player.getDisplayName() + MashedMC.PRIMARY + " died at X = " + MashedMC.SECONDARY + eyeLocation.getBlockX() + MashedMC.PRIMARY + ", Y = " + MashedMC.SECONDARY + eyeLocation.getBlockY() + MashedMC.PRIMARY + ", Z = " + MashedMC.SECONDARY + eyeLocation.getBlockZ()));
    }
}
