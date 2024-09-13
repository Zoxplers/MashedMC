package com.zoxplers.mashed.DeathCounter;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DeathCounter
{
    //add a way to edit deaths
    //Variables
    private static String filePath;
    private boolean enabled;

    //Functions
    public void enable()
    {
        enabled = true;
        filePath = MashedMC.getInstance().getDataFolder() + File.separator + "deaths";
        MashedMC plugin = MashedMC.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new DeathCounterListeners(), plugin);
    }

    public void disable()
    {
        enabled = false;
    }

    //Add a check to see if users want to save data per death, per player leave, or per plugin disable
    static void saveData(HashMap<UUID, Integer> data)
    {
        if(data == null)
        {
            MashedMC.log("Error trying to save deaths.old: data is null.");
            return;
        }
        try
        {
            File file = new File(filePath);
            BukkitObjectOutputStream out;

            if(file.exists())
            {
                try
                {
                    file.renameTo(new File(MashedMC.getInstance().getDataFolder() + File.separator + "deaths.old"));
                    file = new File(filePath);
                }
                catch (Exception e)
                {
                    MashedMC.log("Error trying to save deaths.old: ", MashedMC.translate(e.getMessage()));
                }
            }

            out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
            out.writeObject(data);
            out.close();
        }
        catch(Exception e)
        {
            MashedMC.log("Error trying to save deaths: ", MashedMC.translate(e.getMessage()));
        }
    }

    @SuppressWarnings("unchecked")
    static HashMap<UUID, Integer> loadData()
    {
        try
        {
            File file = new File(filePath);
            BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
            Object object = in.readObject();

            in.close();
            return (HashMap<UUID, Integer>) object;

        }
        catch(Exception e)
        {
            MashedMC.log("Error trying to load deaths: ", MashedMC.translate(e.getMessage()));
        }

        return new HashMap<>();
    }
}