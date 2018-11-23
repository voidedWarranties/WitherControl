package xyz.voidedxd.withercontrol.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import xyz.voidedxd.withercontrol.WitherControl;

public class WitherListener implements Listener {
    private WitherControl plugin;

    public WitherListener(WitherControl plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void WitherBlockBreak(EntityChangeBlockEvent event) {
        Block block = event.getBlock();
        Entity entity = event.getEntity();
        if(entity.getType() == EntityType.WITHER) {
            if(!plugin.isBreakable(block.getType())) {
                event.setCancelled(true);
            }
        }
    }
}