package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Shotgun extends Weapon {
    public Shotgun() {
        super("Shotgun", Main.getPlugin(), 5, 20, false, false,
                false, Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, 1, 0.2F);
    }

    @Override
    public void useEffects(Player player, UseType useType) {
        for (int i = 0; i < 15; i++) {
            shootItem(player,1,new ItemBuilder(Material.STONE_BUTTON,1).build(),2,0.2F,
                    false,false,false);
        }
    }

    @Override
    public boolean hasRequirements(Player player) {
        return true;
    }

    @Override
    public ShapedRecipe getRecipe() {
        return super.getRecipe().shape(
                "IBB",
                " WB",
                "  W")
                .setIngredient('I',Material.IRON_INGOT)
                .setIngredient('B',Material.IRON_BLOCK)
                .setIngredient('W',new RecipeChoice.MaterialChoice(
                Material.SPRUCE_WOOD,Material.OAK_WOOD,Material.ACACIA_WOOD,Material.DARK_OAK_WOOD,
                Material.BIRCH_WOOD,Material.CHERRY_WOOD,Material.MANGROVE_WOOD,Material.JUNGLE_WOOD,
                Material.CRIMSON_HYPHAE,Material.WARPED_HYPHAE,Material.BAMBOO_MOSAIC));
    }

    @Override
    public ItemStack getAmmoItem() {
        return new ShellBullet().getItem().asQuantity(2);
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.ECHO_SHARD,1).setName("<aqua>"+getName()).build();
    }
}
