package xyz.voidedxd.withercontrol;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.voidedxd.withercontrol.commands.CommandWhitelist;
import xyz.voidedxd.withercontrol.event.WitherListener;

import java.util.logging.Logger;

public final class WitherControl extends JavaPlugin {

    private Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = getLogger();
        LOGGER.info("Enabling WitherControl");
        new WitherListener(this);
        loadConfig();
        this.getCommand("witherwl").setExecutor(new CommandWhitelist(this));
    }

    @Override
    public void onDisable() {
        LOGGER.info("Disabling WitherControl");
        saveConfig();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public boolean isBreakable(Material mat) {
        if(getConfig().get(mat.toString()) == null) {
            return false;
        }
        return (boolean) getConfig().get(mat.toString());
    }
}
