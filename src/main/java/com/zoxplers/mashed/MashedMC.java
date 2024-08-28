package com.zoxplers.mashed;

import com.zoxplers.mashed.AutoHarvest.AutoHarvest;
import com.zoxplers.mashed.BatMembranes.BatMembranes;
import com.zoxplers.mashed.CopperOresDropCoal.CopperOresDropCoal;
import org.bukkit.plugin.java.JavaPlugin;

public class MashedMC extends JavaPlugin
{
    //Variables
    private static MashedMC instance;
    private static AutoHarvest autoHarvest;
    private static CopperOresDropCoal copperOresDropCoal;
    private static BatMembranes batMembranes;

    //Constructor
    public MashedMC()
    {
        autoHarvest = new AutoHarvest();
        copperOresDropCoal = new CopperOresDropCoal();
        batMembranes = new BatMembranes();
    }

    //Functions
    @Override
    public void onEnable()
    {
        MashedMC.instance = this;
        autoHarvest.enable();
        copperOresDropCoal.enable();
        batMembranes.enable();
    }
    @Override
    public void onDisable()
    {
        MashedMC.instance = null;
        autoHarvest.disable();
        copperOresDropCoal.disable();
        batMembranes.disable();
    }

    public static MashedMC getInstance()
    {
        return MashedMC.instance;
    }
}
