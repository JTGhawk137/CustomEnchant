package me.jtghawk137.ce.enchants;

import me.jtghawk137.ce.config.FileManager;
import org.apache.commons.lang.WordUtils;
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
        if (level > enchantment.getMaxLevel())
            throw new ArrayIndexOutOfBoundsException();
        ItemStack stack = new ItemStack(material, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(FileManager.get("settings.yml").get("itemName").toString().replace("&", "§") + " " + WordUtils.capitalize(material.name().replace("_", " ").toLowerCase()));
        meta.setLore(Arrays.asList("§7" + enchantment.getName() + " " + numerals[level - 1]));
        if (showUser())
            meta.setLore(Arrays.asList(("§7" + enchantment.getName() + " " + numerals[level - 1]), FileManager.get("settings.yml").getString("originalUserLore").replace("&", "§") + player.getName()));
        stack.setItemMeta(meta);
        stack.addUnsafeEnchantment(enchantment, level);
        stack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        return stack;
    }

    private static boolean showUser()
    {
        return FileManager.get("settings.yml").getBoolean("showOriginalUser");
    }
}
