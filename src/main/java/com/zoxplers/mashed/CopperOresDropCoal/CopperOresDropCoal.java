package com.zoxplers.mashed.CopperOresDropCoal;

import com.zoxplers.mashed.MashedMC;

public class CopperOresDropCoal
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        MashedMC plugin = MashedMC.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new BlockDropItemListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
