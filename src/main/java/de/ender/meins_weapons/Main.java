package de.ender.meins_weapons;

import de.ender.core.Log;
import de.ender.core.UpdateChecker;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.plexus.util.cli.shell.Shell;

public final class Main extends JavaPlugin {
    private static Main plugin;

    @Override
    public void onEnable() {
        Log.enable(this);
        new UpdateChecker(this,"github-dotEXE","meins_weapons","master").check().downloadLatestMeins();
        plugin = this;
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new TestStand(),this);

        getCommand("teststand").setExecutor(new TestStand());

        new TestWeapon().init();
        new ShortBow().init();
        new FireBall().init();
        new WandOfFire().init();
        new Bullet().init();
        new Rifle().init();
        new BigBullet().init();
        new Sniper().init();
        new ShellBullet().init();
        new Shotgun().init();
        new FlameThrower().init();
        new HydrogenBottle().init();
    }

    @Override
    public void onDisable() {
        Log.disable(this);
    }

    public static Main getPlugin(){
        return plugin;
    }
}
