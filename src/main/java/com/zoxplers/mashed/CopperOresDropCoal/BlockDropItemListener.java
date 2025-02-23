package com.zoxplers.mashed.CopperOresDropCoal;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockDropItemListener implements Listener
{
    //Functions
    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent event)
    {
        if(MashedMC.getInstance().getConfig().getBoolean("CopperOresDropCoal"))
        {
            Material blockMaterial = event.getBlockState().getType();
            if((blockMaterial == Material.COPPER_ORE || blockMaterial == Material.DEEPSLATE_COPPER_ORE) && event.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                event.getPlayer().getWorld().dropItemNaturally(event.getBlockState().getLocation(), new ItemStack(Material.COAL, 1 + new Random().nextInt(2)));
                event.setCancelled(true);
            }
        }
    }
}
