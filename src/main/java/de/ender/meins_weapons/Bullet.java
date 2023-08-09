package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class Bullet extends CustomItem {
    public Bullet() {
        super("Bullet", Main.getPlugin());
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.IRON_NUGGET,1).setName(getName()).build();
    }

    @Override
    protected Recipe getRecipe() {
        return new ShapelessRecipe(getNamespacedKey(),getItem().asQuantity(4)).addIngredient(Material.GUNPOWDER).addIngredient(Material.IRON_NUGGET);
    }
}
