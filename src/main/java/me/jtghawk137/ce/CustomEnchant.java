package me.jtghawk137.ce;

import me.jtghawk137.ce.config.FileManager;
import me.jtghawk137.ce.enchants.EnchantmentHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchant extends JavaPlugin
{

    private EnchantmentHandler handler = new EnchantmentHandler();
    private FileManager files = new FileManager();
    private static CustomEnchant instance;

    @Override
    public void onEnable()
    {
        instance = this;
        files.loadConfigs();
        handler.registerEnchantments();
    }

    @Override
    public void onDisable()
    {
        instance = null;
        handler.handleShutdown();
    }

    public static CustomEnchant getInstance()
    {
        return instance;
    }
}
