package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.weapons.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class WandOfFire extends Weapon {


    public WandOfFire() {
        super("Wand-of-Fire", Main.getPlugin(), 1, 8, false, false,
                false, Sound.ITEM_FIRECHARGE_USE, 1, 2);
    }
    
    public ItemStack getItemStack() {
        return new ItemBuilder(Material.STICK,1).addEnchantmentGlint().addEnchantmentGlint().setName("<aqua>"+getName()).build();
    }

    
    public ShapedRecipe getRecipe() {
        return super.getRecipe().shape(
                "F  ",
                " S ",
                "  S")
                .setIngredient('F',new FireBall().getItem())
                .setIngredient('S',Material.STICK);
    }
    
    public void rangedEntityHit(Player player, EntityDamageByEntityEvent event) {
        event.getEntity().setFireTicks(20);
        super.rangedEntityHit(player, event);
    }
    
    public void useEffects(Player player, UseType useType) {
        shootItem(player,2,new ItemBuilder(Material.COAL,1).addEnchantmentGlint().build(),
                0.10F,5,false,true,true);
    }

    
    public ItemStack getAmmoItem() {
        return new ItemBuilder(Material.QUARTZ,1).build();
    }
    
    public void rangedHit(Player player, ProjectileHitEvent event) {
        super.rangedHit(player, event);
        Block block = event.getHitBlock();
        BlockFace blockFace = event.getHitBlockFace();
        if(blockFace != null&& block!= null &&block.getType().isBurnable()) {
            Block fireblock = block.getRelative(blockFace);
            if(!fireblock.getType().toString().toLowerCase().contains("air")) return;
            fireblock.setType(Material.FIRE);
            Fire fire = (Fire) Bukkit.createBlockData(Material.FIRE);
            fire.getFaces().forEach((fireFace)->fire.setFace(fireFace, false));
            if(fire.getAllowedFaces().contains(blockFace.getOppositeFace())) fire.setFace(blockFace.getOppositeFace(),true);
            fireblock.setBlockData(fire);
        }
    }

    
    public boolean hasRequirements(Player player) {
        return true;
    }
}
