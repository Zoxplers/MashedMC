package com.zoxplers.mashed.BatMembranes;

import com.zoxplers.mashed.MashedMC;

public class BatMembranes
{
    //Variables
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        MashedMC plugin = MashedMC.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new EntityDeathListener(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }
}
