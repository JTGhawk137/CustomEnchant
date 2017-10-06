package me.jtghawk137.ce;

import me.jtghawk137.ce.commands.CECommand;
import me.jtghawk137.ce.enchants.EnchantmentHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchant extends JavaPlugin
{

    private static CustomEnchant instance;
    private EnchantmentHandler handler = new EnchantmentHandler();

    public static CustomEnchant getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        handler.registerEnchantments();
        registerCommands();
        handler.registerEvents();
    }

    @Override
    public void onDisable()
    {
        instance = null;
        handler.handleShutdown();
    }

    public void registerCommands()
    {
        this.getCommand("ce").setExecutor(new CECommand());
    }
}
