package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.Main;
import de.ender.core.weapons.Weapon;
import de.ender.core.weapons.Weapons;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class TestWeapon implements Weapon {
    @Override
    public JavaPlugin getPlugin() {
        return Main.getPlugin();
    }
    @Override
    public String getName(){
        return "TestWeapon";
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.IRON_NUGGET,1).setLoreAt(0, ChatColor.GRAY+getUUID().toString()).setName("§b"+getName()).build();
    }

    @Override
    public long getReloadTime() {
        return (long) (0.1*1000);
    }

    @Override
    public void useEffects(Player player, Weapons.UseType useType) {
        player.sendMessage(useType.toString());
    }

    @Override
    public ItemStack getAmmoItem(Weapons.UseType useType) {
        return new ItemBuilder(Material.DIRT,1).build();
    }

    @Override
    public double getDamage() {
        return 1;
    }

    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }

    @Override
    public void rangedEntityHit(Player player, EntityDamageByEntityEvent event) {

    }
}
