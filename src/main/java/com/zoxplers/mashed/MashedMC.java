package com.zoxplers.mashed;

import com.zoxplers.mashed.AutoHarvest.AutoHarvest;
import com.zoxplers.mashed.BatMembranes.BatMembranes;
import com.zoxplers.mashed.CopperOresDropCoal.CopperOresDropCoal;
import com.zoxplers.mashed.DeathCoordinates.DeathCoordinates;
import com.zoxplers.mashed.DeathCounter.DeathCounter;
import com.zoxplers.mashed.FastAscend.FastAscend;
import com.zoxplers.mashed.OreGenerator.OreGenerator;
import com.zoxplers.mashed.WoolToString.WoolToString;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MashedMC extends JavaPlugin
{
    //Variables
    private static MashedMC instance;
    private static AutoHarvest autoHarvest;
    private static CopperOresDropCoal copperOresDropCoal;
    private static BatMembranes batMembranes;
    private static DeathCoordinates deathCoordinates;
    private static DeathCounter deathCounter;
    private static WoolToString woolToString;
    private static OreGenerator oreGenerator;
    private static FastAscend fastAscend;
    public static final String PRIMARY = "#b7d3e9", SECONDARY = "#87cc74"; //move to config file

    //Constructor
    public MashedMC()
    {
        autoHarvest = new AutoHarvest();
        copperOresDropCoal = new CopperOresDropCoal();
        batMembranes = new BatMembranes();
        deathCoordinates = new DeathCoordinates();
        deathCounter = new DeathCounter();
        woolToString = new WoolToString();
        oreGenerator = new OreGenerator();
        fastAscend = new FastAscend();
    }

    //Functions

    /*
        Changes message string to color supported message string.
     */
    public static String translate(String msg)
    {
        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(msg);
        String color;

        while(matcher.find())
        {
            color = msg.substring(matcher.start(), matcher.end());
            msg = msg.replace(color, ChatColor.of(color) + "");
            matcher = pattern.matcher(msg);
        }

        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void log(String... strings)
    {
        instance.getServer().getConsoleSender().sendMessage(strings);
    }

    @Override
    public void onEnable()
    {
        MashedMC.instance = this;
        autoHarvest.enable();
        copperOresDropCoal.enable();
        batMembranes.enable();
        deathCoordinates.enable();
        deathCounter.enable();
        woolToString.enable();
        oreGenerator.enable();
        fastAscend.enable();

        File file = new File(instance.getDataFolder() + "/");
        if(!file.exists())
        {
            file.mkdirs();
        }
    }
    @Override
    public void onDisable()
    {
        MashedMC.instance = null;
        autoHarvest.disable();
        copperOresDropCoal.disable();
        batMembranes.disable();
        deathCoordinates.disable();
        deathCounter.disable();
        woolToString.disable();
        oreGenerator.disable();
        fastAscend.disable();
    }

    public static MashedMC getInstance()
    {
        return MashedMC.instance;
    }
}
