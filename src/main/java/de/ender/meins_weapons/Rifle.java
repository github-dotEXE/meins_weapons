package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Rifle extends Weapon {
    public Rifle() {
        super("Rifle", Main.getPlugin(), 2, 15, true, false, false,
                Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 0.5F);
    }

    @Override
    public ShapedRecipe getRecipe() {
        return super.getRecipe().shape(
                "IBB",
                "I B",
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

    public ItemStack getAmmoItem() {
        return new Bullet().getItem();
    }

    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.BLACK_DYE,1).setName("<aqua>"+getName()).build();
    }
}
