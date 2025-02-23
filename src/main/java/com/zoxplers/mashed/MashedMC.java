package com.zoxplers.mashed;

import com.zoxplers.mashed.AutoHarvest.AutoHarvest;
import com.zoxplers.mashed.BarkLogs.BarkLogs;
import com.zoxplers.mashed.BatMembranes.BatMembranes;
import com.zoxplers.mashed.CopperOresDropCoal.CopperOresDropCoal;
import com.zoxplers.mashed.DeathCoordinates.DeathCoordinates;
import com.zoxplers.mashed.DeathCounter.DeathCounter;
import com.zoxplers.mashed.DirtPath.DirtPath;
import com.zoxplers.mashed.FastAscend.FastAscend;
import com.zoxplers.mashed.OreGenerator.OreGenerator;
import com.zoxplers.mashed.OtherModules.CommandListener;
import com.zoxplers.mashed.WoolToString.WoolToString;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.PluginCommand;
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
    private static DirtPath dirtPath;
    private static BarkLogs barkLogs;
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
        barkLogs = new BarkLogs();
        dirtPath = new DirtPath();
    }

    //Functions

    /**
     * Changes message string to color supported message string.
     * @param msg Message to translate
     * @return Translated message
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
        PluginCommand command;
        MashedMC.instance = this;
        autoHarvest.enable();
        barkLogs.enable();
        batMembranes.enable();
        copperOresDropCoal.enable();
        deathCoordinates.enable();
        deathCounter.enable();
        dirtPath.enable();
        fastAscend.enable();
        oreGenerator.enable();
        woolToString.enable();

        saveDefaultConfig();

        command = this.getCommand("reloadconfig");
        if(command!=null)
        {
            command.setExecutor(new CommandListener());
        }
    }
    @Override
    public void onDisable()
    {
        MashedMC.instance = null;
        autoHarvest.disable();
        barkLogs.disable();
        batMembranes.disable();
        copperOresDropCoal.disable();
        deathCoordinates.disable();
        deathCounter.disable();
        dirtPath.disable();
        fastAscend.disable();
        oreGenerator.disable();
        woolToString.disable();
    }

    public static MashedMC getInstance()
    {
        return MashedMC.instance;
    }
}
