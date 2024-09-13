package com.zoxplers.mashed.OreGenerator;

import com.zoxplers.mashed.MashedMC;

public class OreGenerator
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        MashedMC plugin = MashedMC.getInstance();
        enabled = true;
        plugin.getServer().getPluginManager().registerEvents(new BlockFormListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
