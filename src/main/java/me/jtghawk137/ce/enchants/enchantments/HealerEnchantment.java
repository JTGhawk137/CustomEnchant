package me.jtghawk137.ce.enchants.enchantments;

import me.jtghawk137.ce.enchants.EnchantmentHandler;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HealerEnchantment extends Enchantment implements Listener
{

    public HealerEnchantment(int id)
    {
        super(id);
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e)
    {
        if (!(e.getEntity() instanceof LivingEntity && e.getDamager() instanceof Player))
            return;
        LivingEntity damaged = (LivingEntity) e.getEntity();
        Player player = (Player) e.getDamager();
        ItemStack item = player.getInventory().getItemInHand();
        if (item.getEnchantments().containsKey(EnchantmentHandler.getEnchantmentByName(getName())))
        {
            double rand = Math.random();
            if (item.getEnchantments().get(this) == 1)
            {
                if (rand <= .01)
                {
                    player.setHealth(player.getHealth() + 8);
                    damaged.sendMessage("§cYou've been struck by " + player.getName() + "'s Royal Sword");
                    return;
                }
            } else if (item.getEnchantments().get(this) == 2)
            {
                if (rand <= .02)
                {
                    player.setHealth(player.getHealth() + 8);
                    damaged.sendMessage("§cYou've been struck by " + player.getName() + "'s Royal Sword");
                    return;
                }
            } else
            {
                if (rand <= .03)
                {
                    player.setHealth(player.getHealth() + 8);
                    damaged.sendMessage("§cYou've been struck by " + player.getName() + "'s Royal Sword");
                    return;
                }
            }
        }
    }

    @Override
    public String getName()
    {
        return "Healer";
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
