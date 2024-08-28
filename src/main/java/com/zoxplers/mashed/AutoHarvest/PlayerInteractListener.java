package com.zoxplers.mashed.AutoHarvest;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class PlayerInteractListener implements Listener
{
    //Variables
    ArrayList<Material> replant;

    public PlayerInteractListener()
    {
        replant = new ArrayList<Material>();
        replant.add(Material.WHEAT);
        replant.add(Material.BEETROOTS);
        replant.add(Material.CARROTS);
        replant.add(Material.POTATOES);
        replant.add(Material.COCOA);
        replant.add(Material.NETHER_WART);
    }

    //Functions
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Block block = event.getClickedBlock();

        if(block != null && event.getAction() == Action.RIGHT_CLICK_BLOCK && replant.contains(block.getType()))
        {
            Ageable ageable = (Ageable)block.getBlockData();
            if(ageable.getAge() == ageable.getMaximumAge() && block.breakNaturally(event.getPlayer().getInventory().getItemInMainHand()))
            {
                ageable.setAge(0);
                event.getClickedBlock().setBlockData(ageable);
            }
        }
    }
}