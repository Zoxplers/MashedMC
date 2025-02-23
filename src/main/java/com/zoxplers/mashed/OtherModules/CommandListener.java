package com.zoxplers.mashed.OtherModules;

import com.zoxplers.mashed.MashedMC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;


public class CommandListener implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof ConsoleCommandSender)
        {
            sender.sendMessage("MashedMC config reloaded.");
            MashedMC.getInstance().reloadConfig();
        }
        else
        {
            sender.sendMessage("Console usage only.");
        }
        return true;
    }
}
