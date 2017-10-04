package me.jtghawk137.ce;

import me.jtghawk137.ce.commands.GiveCommand;
import me.jtghawk137.ce.config.FileManager;
import me.jtghawk137.ce.enchants.EnchantmentHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchant extends JavaPlugin
{

    private static CustomEnchant instance;
    private EnchantmentHandler handler = new EnchantmentHandler();

    @Override
    public void onEnable()
    {
        instance = this;
        FileManager.loadConfigs();
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
        this.getCommand("give").setExecutor(new GiveCommand());
    }

    public static CustomEnchant getInstance()
    {
        return instance;
    }
}
