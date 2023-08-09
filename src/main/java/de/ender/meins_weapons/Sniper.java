package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.weapons.Weapon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Sniper extends Weapon {
    public Sniper() {
        super("Sniper", Main.getPlugin(), 5, 22, true, false, false,
                Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 0.15F);
    }

    @Override
    public ShapedRecipe getRecipe() {
        return super.getRecipe().shape(
                "IIB",
                " IB",
                "  W")
                .setIngredient('I',Material.IRON_INGOT)
                .setIngredient('B',Material.IRON_BLOCK)
                .setIngredient('W', new RecipeChoice.MaterialChoice(
                        Material.SPRUCE_WOOD,Material.OAK_WOOD,Material.ACACIA_WOOD,Material.DARK_OAK_WOOD,
                        Material.BIRCH_WOOD,Material.CHERRY_WOOD,Material.MANGROVE_WOOD,Material.JUNGLE_WOOD,
                        Material.CRIMSON_HYPHAE,Material.WARPED_HYPHAE,Material.BAMBOO_MOSAIC));
    }

    @Override
    public void useEffects(Player player, UseType useType) {
            shootAmmo(player,4,0.17F,10,false,false,false);
    }

    @Override
    public ItemStack getAmmoItem() {
        return new BigBullet().getItem();
    }
    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.BLACK_DYE,1).setName("<aqua>"+getName()).build();
    }

    @Override
    public void rangedEntityHit(Player player, EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if(entity.getLocation().getY()+entity.getHeight()*0.75<event.getDamager().getLocation().getY()) event.setDamage(getDamage()*1.75);
        else event.setDamage(getDamage());
    }
}
