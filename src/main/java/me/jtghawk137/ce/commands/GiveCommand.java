package me.jtghawk137.ce.commands;

import me.jtghawk137.ce.enchants.EnchantmentHandler;
import me.jtghawk137.ce.enchants.ItemUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements CommandExecutor
{

    private EnchantmentHandler handler = new EnchantmentHandler();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if (!(commandSender instanceof Player))
        {
            return true;
        }
        Player player = (Player) commandSender;
        player.getInventory().addItem(ItemUtils.customEnchantItem(Material.DIAMOND_SWORD, 1, handler.getEnchantments().get(0), 3, player));
        return true;
    }
}
