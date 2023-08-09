package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class ShortBow extends Weapon {
    public ShortBow() {
        super("Short-Bow", Main.getPlugin(), 0.15F, 8, false, false, false,
                Sound.ENTITY_ARROW_SHOOT, 1, 1);
    }

    public ItemStack getItemStack() {
        return new ItemBuilder(Material.BOW,1).setName("<aqua>"+getName()).build();
    }

    public ShapedRecipe getRecipe() {
        return super.getRecipe().shape(
                "SI ",
                "S D",
                "SI ")
                .setIngredient('S',Material.STRING)
                .setIngredient('I',Material.STICK)
                .setIngredient('D',Material.DIAMOND);
    }

    public void useEffects(Player player, UseType useType) {
        shootArrow(player,1,0.15F,Float.MAX_VALUE,true,false,
                false, AbstractArrow.PickupStatus.DISALLOWED);
    }

    public ItemStack getAmmoItem() {
        return new ItemBuilder(Material.ARROW,1).build();
    }

    public boolean hasRequirements(Player player) {
        return true;
    }
}
