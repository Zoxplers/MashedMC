package com.zoxplers.mashed.DirtPath;

import com.zoxplers.mashed.MashedMC;

public class DirtPath
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
