package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItems;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class WandOfFire implements Weapon {
    @Override
    public JavaPlugin getPlugin() {
        return Main.getPlugin();
    }

    @Override
    public String getName() {
        return "Wand-of-Fire";
    }

    @Override
    public ItemStack getItem() {
        return new ItemBuilder(Material.STICK,1).addEnchantmentGlint().addEnchantmentGlint().setName("§b"+getName()).build();
    }

    @Override
    public ShapedRecipe getRecipe() {
        return Weapon.super.getRecipe().shape(
                "F  ",
                " S ",
                "  S")
                .setIngredient('F',new FireBall().getItem())
                .setIngredient('S',Material.STICK);
    }

    @Override
    public void rangedEntityHit(Player player, EntityDamageByEntityEvent event) {
        Weapon.super.rangedEntityHit(player, event);
        event.getEntity().setFireTicks(20);
    }

    @Override
    public long getReloadTime() {
        return 1;
    }

    @Override
    public void useEffects(Player player, CustomItems.UseType useType) {
        Snowball snowball = player.launchProjectile(Snowball.class);
        float projectileSpeed = 2;
        snowball.setVelocity(snowball.getVelocity().multiply(projectileSpeed));
        snowball.setGravity(false);
        snowball.setVisualFire(true);
        snowball.setGlowing(true);
        snowball.setItem(new ItemBuilder(Material.COAL,1).addEnchantmentGlint().build());
        new BukkitRunnable() {
            @Override
            public void run() {
                snowball.remove();
            }
        }.runTaskLater(Main.getPlugin(),5*20);
    }

    @Override
    public ItemStack getAmmoItem(CustomItems.UseType useType) {
        return new ItemBuilder(Material.QUARTZ,1).build();
    }

    @Override
    public double getDamage() {
        return 8;
    }

    @Override
    public void rangedHit(Player player, ProjectileHitEvent event) {
        Weapon.super.rangedHit(player, event);
        Block block = event.getHitBlock();
        if(block != null &&block.getType().isBurnable()) block.setType(Material.FIRE);
    }

    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }
}
