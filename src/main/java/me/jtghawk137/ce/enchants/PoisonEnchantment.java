package me.jtghawk137.ce.enchants;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PoisonEnchantment extends Enchantment implements Listener
{

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e)
    {

    }

    public PoisonEnchantment(int id)
    {
        super(id);
    }

    @Override
    public String getName()
    {
        return "Poison";
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }

    @Override
    public int getStartLevel()
    {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public boolean isTreasure()
    {
        return false;
    }

    @Override
    public boolean isCursed()
    {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment)
    {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack)
    {
        return false;
    }
}
