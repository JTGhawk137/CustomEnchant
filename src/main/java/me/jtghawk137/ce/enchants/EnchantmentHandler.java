package me.jtghawk137.ce.enchants;

import com.google.common.collect.Lists;
import me.jtghawk137.ce.CustomEnchant;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

public class EnchantmentHandler
{

    private static List<Enchantment> enchantments = Lists.newArrayList();
    private PoisonEnchantment poison;
    private CustomEnchant instance = CustomEnchant.getInstance();

    public void registerEnchantments()
    {
        poison = new PoisonEnchantment(101);
        enchantments.add(poison);

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

            for (Enchantment e : enchantments)
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
        instance.getServer().getPluginManager().registerEvents(poison, instance);
    }

    public static List<Enchantment> getEnchantments()
    {
        return enchantments;
    }
}
