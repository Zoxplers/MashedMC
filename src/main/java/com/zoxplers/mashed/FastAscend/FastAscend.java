package com.zoxplers.mashed.FastAscend;

import com.zoxplers.mashed.MashedMC;

public class FastAscend
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        MashedMC plugin = MashedMC.getInstance();
        enabled = true;
        plugin.getServer().getPluginManager().registerEvents(new PlayerMoveListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
