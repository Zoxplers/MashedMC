package com.zoxplers.mashed.DirtPath;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if(MashedMC.getInstance().getConfig().getBoolean("DirtPath"))
        {
            if(event.getItem() != null && event.getClickedBlock()!= null  && event.getItem().getType().toString().toUpperCase().contains("_SHOVEL") && event.getClickedBlock().getType() == Material.DIRT_PATH)
            {
                event.getClickedBlock().setType(Material.DIRT);
            }
        }
    }
}