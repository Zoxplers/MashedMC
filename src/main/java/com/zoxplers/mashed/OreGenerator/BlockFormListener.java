package com.zoxplers.mashed.OreGenerator;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import java.util.Random;

public class BlockFormListener implements Listener
{
    //Variables
    Random random;

    //Constructor
    public BlockFormListener()
    {
        random = new Random();
    }

    //Functions
    @EventHandler
    public void onBlockForm(BlockFormEvent event)
    {
        if(event.getNewState().getType() == Material.COBBLESTONE)
        {
            event.getNewState().setType(Material.STONE);
            event.getNewState().update(true);
        }

        if(event.getNewState().getType() == Material.STONE)
        {
            event.getNewState().setType(getRandomMaterial());
            event.getNewState().update(true);
        }
    }

    public Material getRandomMaterial()
    {
        if(random.nextInt(0,11) > 8)
        {
            if(random.nextInt(0, 3) == 2)
            {
                return Material.IRON_ORE;
            }
            if(random.nextInt(0, 10) == 9)
            {
                if(random.nextInt(0, 10) == 9)
                {
                    if(random.nextInt(0, 2) == 1)
                    {
                        return Material.OBSIDIAN;
                    }
                    if(random.nextInt(0, 10) == 9)
                    {
                        return Material.DIAMOND_ORE;
                    }
                    return Material.EMERALD_ORE;
                }
                return Material.GOLD_ORE;
            }
            return Material.COAL_ORE;
        }
        return Material.STONE;
    }
}
