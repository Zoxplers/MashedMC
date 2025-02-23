package com.zoxplers.mashed.BarkLogs;

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
        if(MashedMC.getInstance().getConfig().getBoolean("BarkLogs"))
        {
            if (event.getItem() != null && event.getClickedBlock() != null && event.getItem().getType().toString().toUpperCase().contains("_AXE") && event.getClickedBlock().getType().toString().toUpperCase().startsWith("STRIPPED_")) {
                Material material = Material.matchMaterial(event.getClickedBlock().getType().toString().replaceFirst("STRIPPED_", ""));
                if (material != null) {
                    event.getClickedBlock().setType(material);
                }
            }
        }
    }
}