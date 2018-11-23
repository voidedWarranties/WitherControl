package xyz.voidedxd.withercontrol.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.voidedxd.withercontrol.WitherControl;

public class CommandWhitelist implements CommandExecutor {
    private WitherControl plugin;

    public CommandWhitelist(WitherControl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Material mat;
        if(args == null) {
            return false;
        }

        if(args[0] == null) {
            return false;
        }

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(!sender.hasPermission("withercontrol.whitelist.add")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to add to the WitherControl Whitelist.");
                return true;
            }
            System.out.println(args[0]);
            mat = Material.getMaterial(args[0]);
            if(mat != null) {
                plugin.getConfig().set(mat.toString(), true);
                plugin.saveConfig();
                player.sendMessage("Successfully added that block to the whitelist.");
                player.sendMessage(mat.toString());
            }
        }
        return true;
    }
}