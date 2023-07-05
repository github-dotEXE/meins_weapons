package de.ender.meins_weapons;

import de.ender.core.Log;
import de.ender.core.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main plugin;

    @Override
    public void onEnable() {
        Log.enable(this);
        new UpdateChecker(this,"github-dotEXE","meins_weapons","master").check().downloadLatestMeins();
        plugin = this;

        new TestWeapon().init();
        new ShortBow().init();
    }

    @Override
    public void onDisable() {
        Log.disable(this);
    }

    public static Main getPlugin(){
        return plugin;
    }
}
