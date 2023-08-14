package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.customItems.CustomItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.PotionMeta;

public class HydrogenBottle extends CustomItem {

    public HydrogenBottle() {
        super("Bottle-of-Hydrogen", Main.getPlugin());
    }

    @Override
    protected ItemStack getItemStack() {
        ItemStack item = new ItemBuilder(Material.POTION,1).setName(getName()).build();
        PotionMeta potion = (PotionMeta) item.getItemMeta();
        potion.setColor(Color.fromRGB(174,226,253));
        //potion.getCustomEffects().forEach((potionEffect -> potion.removeCustomEffect(potionEffect.getType())));
        item.setItemMeta(potion);
        return item;
    }

    @Override
    protected Recipe getRecipe() {
        return null;
    }
}
