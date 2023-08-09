package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class ShellBullet extends CustomItem {
    public ShellBullet() {
        super("Shell", Main.getPlugin());
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.REDSTONE_TORCH,1).setName(getName()).build();
    }

    @Override
    protected Recipe getRecipe() {
        return new ShapelessRecipe(getNamespacedKey(),getItem().asQuantity(1)).addIngredient(Material.REDSTONE)
                .addIngredient(Material.GOLD_NUGGET).addIngredient(Material.GUNPOWDER);
    }
}
