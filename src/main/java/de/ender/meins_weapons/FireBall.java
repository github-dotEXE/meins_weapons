package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class FireBall implements CustomItem {
    @Override
    public JavaPlugin getPlugin() {
        return Main.getPlugin();
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemBuilder(Material.FIRE_CHARGE,1).addEnchantmentGlint().setName(getName()).build();
    }

    @Override
    public Recipe getRecipe() {
        return new ShapelessRecipe(getNamespacedKey(),getItem()).addIngredient(4,Material.FIRE_CHARGE);
    }

    @Override
    public String getName() {
        return "Fire-Ball";
    }
}
