package me.jtghawk137.ce.enchants;

import com.google.common.collect.Maps;
import me.jtghawk137.ce.CustomEnchant;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EnchantmentHandler
{

    private static Map<String, Enchantment> enchantments = Maps.newHashMap();
    private PoisonEnchantment poison;

    public static Map<String, Enchantment> getEnchantments()
    {
        return enchantments;
    }

    public static Enchantment getEnchantmentByName(String name)
    {
        return enchantments.get(name);
    }

    public void registerEnchantments()
    {
        poison = new PoisonEnchantment(101);
        enchantments.put("poison", poison);

        try
        {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(poison);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void handleShutdown()
    {
        try
        {
            Field byIdField = Enchantment.class.getDeclaredField("byId");
            Field byNameField = Enchantment.class.getDeclaredField("byName");

            byIdField.setAccessible(true);
            byNameField.setAccessible(true);

            HashMap<Integer, Enchantment> byId = (HashMap<Integer, Enchantment>) byIdField.get(null);
            HashMap<Integer, Enchantment> byName = (HashMap<Integer, Enchantment>) byNameField.get(null);

            for (Enchantment e : enchantments.values())
            {
                if (byId.containsKey(e.getId()))
                    byId.remove(e.getId());
                if (byName.containsKey(e.getName()))
                    byName.remove(e.getName());
            }
        } catch (Exception ignored)
        {
        }
    }

    public void registerEvents()
    {
        CustomEnchant.getInstance().getServer().getPluginManager().registerEvents(poison, CustomEnchant.getInstance());
    }
}
