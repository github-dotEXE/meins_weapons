package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.Main;
import de.ender.core.customItems.CustomItems;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
        return new ItemBuilder(Material.IRON_NUGGET,1).setName("§b"+getName()).build();
    }

    @Override
    public long getReloadTime() {
        return (long) (0.1*1000);
    }

    @Override
    public void useEffects(Player player, CustomItems.UseType useType) {
        player.sendMessage(useType.toString());
    }

    @Override
    public ItemStack getAmmoItem(CustomItems.UseType useType) {
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
    public void missingRequirements(Player player) {
        Weapon.super.missingRequirements(player);
        player.sendMessage("MissingReqirements");
    }

    @Override
    public void error(Player player) {
        Weapon.super.error(player);
        player.sendMessage("Error");
    }

    @Override
    public void onCooldown(Player player) {
        Weapon.super.onCooldown(player);
        player.sendMessage("OnCooldown");
    }

    @Override
    public void noAmmo(Player player) {
        Weapon.super.noAmmo(player);
        player.sendMessage("NoAmmo");
    }
}
