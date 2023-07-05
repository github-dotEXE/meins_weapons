package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.Log;
import de.ender.core.weapons.Weapon;
import de.ender.core.weapons.Weapons;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
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
    public void useEffects(Player player, Weapons.UseType useType) {
        Arrow arrow = player.launchProjectile(Arrow.class);
        float projectileSpeed = 1;
        arrow.setVelocity(arrow.getVelocity().multiply(projectileSpeed));
        arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        arrow.setDamage(0);
    }

    @Override
    public ItemStack getAmmoItem(Weapons.UseType useType) {
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

    @Override
    public void rangedEntityHit(Player player, EntityDamageByEntityEvent event) {
        Weapon.super.rangedEntityHit(player,event);
    }

    @Override
    public void rangedHit(Player player, ProjectileHitEvent event) {
        Weapon.super.rangedHit(player, event);
    }
}
