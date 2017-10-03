package me.jtghawk137.ce.enchants;

import me.jtghawk137.ce.CustomEnchant;
import me.jtghawk137.ce.config.FileManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtils
{

    private List<Enchantment> enchantments = EnchantmentHandler.getEnchantments();
    private CustomEnchant instance = CustomEnchant.getInstance();

    //TODO: Finish
    public ItemStack customEnchantItem(Material material, int amount)
    {
        ItemStack stack = new ItemStack(material, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(FileManager.get("settings.yml").get("itemName").toString().replace("&", "§") + " " + material.name());
        return stack;
    }
}
