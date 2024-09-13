package com.zoxplers.mashed.DeathCoordinates;

import com.zoxplers.mashed.MashedMC;

public class DeathCoordinates
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        MashedMC plugin = MashedMC.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeathListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
