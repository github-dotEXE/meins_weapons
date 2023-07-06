package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItems;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ShortBow implements Weapon {
    @Override
    public JavaPlugin getPlugin() {
        return Main.getPlugin();
    }

    @Override
    public String getName() {
        return "Short-Bow";
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.BOW,1).setName("§b"+getName()).build();
    }

    @Override
    public ShapedRecipe getRecipe() {
        return Weapon.super.getRecipe().shape(
                "SI ",
                "S D",
                "SI ")
                .setIngredient('S',Material.STRING)
                .setIngredient('I',Material.STICK)
                .setIngredient('D',Material.DIAMOND);
    }

    @Override
    public long getReloadTime() {
        return (long) (0.15*1000);
    }

    @Override
    public void useEffects(Player player, CustomItems.UseType useType) {
        Arrow arrow = player.launchProjectile(Arrow.class);
        float projectileSpeed = 1;
        arrow.setVelocity(arrow.getVelocity().multiply(projectileSpeed));
        arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        arrow.setDamage(0);
    }

    @Override
    public ItemStack getAmmoItem(CustomItems.UseType useType) {
        return new ItemBuilder(Material.ARROW,1).build();
    }

    @Override
    public double getDamage() {
        return 6;
    }

    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }
}
