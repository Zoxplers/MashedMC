package com.zoxplers.mashed.AutoHarvest;

import com.zoxplers.mashed.MashedMC;

public class AutoHarvest
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        MashedMC plugin = MashedMC.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
