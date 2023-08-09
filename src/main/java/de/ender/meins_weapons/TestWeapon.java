package de.ender.meins_weapons;

import de.ender.core.ItemBuilder;
import de.ender.core.Main;
import de.ender.core.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class TestWeapon extends Weapon {

    public TestWeapon() {
        super("TestWeapon", Main.getPlugin(), 0.1F, 1, false, false, false,
                Sound.ENTITY_ARROW_SHOOT, 1, 1);
    }
    public ItemStack getItemStack() {
        return new ItemBuilder(Material.IRON_NUGGET,1).setName("<aqua>"+getName()).build();
    }

    public void useEffects(Player player, UseType useType) {
        player.sendMessage(useType.toString());
        player.sendMessage(player.getEyeLocation().getDirection().clone().multiply(1).add(
                new Vector((Math.random()-0.5)*0,(Math.random()-0.5)*0,(Math.random()-0.5)*0)).toString());
        player.sendMessage(player.launchProjectile(Arrow.class).getVelocity().toString());

    }
    
    public ItemStack getAmmoItem() {
        return new ItemBuilder(Material.DIRT,1).build();
    }
    
    public boolean hasRequirements(Player player) {
        return true;
    }

    public void missingRequirements(Player player) {
        super.missingRequirements(player);
        player.sendMessage("MissingRequirements");
    }

    public void error(Player player) {
        super.error(player);
        player.sendMessage("Error");
    }

    @Override
    protected void switchToSlot(Player player, PlayerItemHeldEvent event) {
        player.sendMessage("Switched to "+getName());
    }

    @Override
    protected void switchFromSlot(Player player, PlayerItemHeldEvent event) {
        player.sendMessage("Switched from "+getName());
    }

    public void onCooldown(Player player) {
        super.onCooldown(player);
        player.sendMessage("OnCooldown");
    }

    public void noAmmo(Player player) {
        super.noAmmo(player);
        player.sendMessage("NoAmmo");
    }
}
