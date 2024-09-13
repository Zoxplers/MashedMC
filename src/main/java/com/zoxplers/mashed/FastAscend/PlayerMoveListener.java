package com.zoxplers.mashed.FastAscend;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;

public class PlayerMoveListener implements Listener
{
    //Variables
    final double CLIMB_PITCH = -50, CLIMB_SPEED = 0.4;
    ArrayList<Material> ascendables;

    //Constructor
    public PlayerMoveListener()
    {
        ascendables = new ArrayList<Material>();
        ascendables.add(Material.WATER);
        ascendables.add(Material.VINE);
        ascendables.add(Material.LADDER);
    }

    //Functions
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        if(player.getLocation().getPitch() < CLIMB_PITCH && event.getTo().getY()-event.getFrom().getY() > 0.1 && ascendables.contains(player.getLocation().add(0,1.1,0).getBlock().getType()))
        {
            player.setVelocity(player.getVelocity().clone().setY(CLIMB_SPEED));
        }
    }
}
