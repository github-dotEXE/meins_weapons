package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class TestStand implements CommandExecutor, Listener {
    private static Entity armorstandEntity;
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!player.hasPermission("weapons.command.teststand")) return false;
        spawnTeststand(player);
        return true;
    }

    public static ItemStack getHead(Player player) {
        ItemStack item = new ItemBuilder(Material.PLAYER_HEAD, 1).build();
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setOwningPlayer(player);
        item.setItemMeta(skull);
        return item;
    }
    private static void spawnTeststand(Player player) {
        remove();
        Location location = player.getLocation();
        World world = location.getWorld();
        armorstandEntity = world.spawnEntity(location, EntityType.ARMOR_STAND);
        armorstandEntity.setCustomNameVisible(true);
        armorstandEntity.customName(miniMessage.deserialize("TestStand"));
        armorstandEntity.setPersistent(true);
        armorstandEntity.setGravity(false);
        ArmorStand armorStand = (ArmorStand) armorstandEntity;
        armorStand.setBasePlate(false);
        armorStand.setDisabledSlots(EquipmentSlot.values());
        armorStand.setArms(true);
        armorStand.setItem(EquipmentSlot.HEAD,getHead(player));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamageEntity(EntityDamageByEntityEvent event){
        if(event.getEntity()!= armorstandEntity) return;
        Bukkit.broadcast(miniMessage.deserialize("<red>Damage: "+event.getDamage()));
        event.setDamage(0);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity()!= armorstandEntity) return;
        if(event.getDamage()!= 0) Bukkit.broadcast(miniMessage.deserialize("<red>Damage by "+event.getCause()+": "+event.getDamage()));
        event.setDamage(0);
    }
    @EventHandler
    public void onDisable(PluginDisableEvent event){
        remove();
    }
    public static void remove(){
        if(armorstandEntity!=null)armorstandEntity.remove();
    }
}
