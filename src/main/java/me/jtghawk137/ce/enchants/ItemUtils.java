package me.jtghawk137.ce.enchants;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemUtils
{
    private static String[] numerals = {"I", "II", "III", "IV", "V"};


    public static ItemStack customEnchantItem(Material material, int amount, Enchantment enchantment, int level, Player player)
    {
        if (material.equals(Material.DIAMOND_SWORD))
        {
            if (level > enchantment.getMaxLevel())
                throw new ArrayIndexOutOfBoundsException();
            ItemStack stack = new ItemStack(material, amount);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§bRoyal Blade");
            meta.setLore(Arrays.asList("§c" + enchantment.getName() + " " + numerals[level - 1], "§cObtained by " + player.getName(), "§9Royal Item"));
            stack.setItemMeta(meta);
            stack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
            stack.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
            stack.addUnsafeEnchantment(enchantment, level);
            return stack;
        } else if (material.equals(Material.DIAMOND_PICKAXE))
        {
            ItemStack stack = new ItemStack(material, amount);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§bRoyal Pickaxe");
            meta.setLore(Arrays.asList("§9Royal Item"));
            stack.setItemMeta(meta);
            stack.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
            stack.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
            return stack;
        } else if (material.equals(Material.DIAMOND_SPADE))
        {
            ItemStack stack = new ItemStack(material, amount);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§bRoyal Shovel");
            meta.setLore(Arrays.asList("§9Royal Item"));
            stack.setItemMeta(meta);
            stack.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
            stack.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
            return stack;
        }
        return null;
    }

}
