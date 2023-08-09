package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class BigBullet extends CustomItem {
    public BigBullet() {
        super("BigBullet", Main.getPlugin());
    }

    @Override
    protected ItemStack getItemStack() {
        return new ItemBuilder(Material.GOLD_NUGGET,1).setName(getName()).build();
    }

    @Override
    protected Recipe getRecipe() {
        return new ShapelessRecipe(getNamespacedKey(),getItem().asQuantity(2)).addIngredient(2,Material.GUNPOWDER).addIngredient(Material.GOLD_INGOT);
    }
}
