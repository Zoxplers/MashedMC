package com.zoxplers.mashed.BatMembranes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Bat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class EntityDeathListener implements Listener
{
    //Functions
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event)
    {
        if(event.getEntity() instanceof Bat)
        {
            ItemStack membranes = new ItemStack(Material.PHANTOM_MEMBRANE, 1 + new Random().nextInt(2));
            ItemMeta membranesMeta = membranes.getItemMeta();
            assert membranesMeta != null;
            membranesMeta.setDisplayName(ChatColor.RESET + "Bat Membrane");
            membranes.setItemMeta(membranesMeta);

            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), membranes);
        }
    }
}
