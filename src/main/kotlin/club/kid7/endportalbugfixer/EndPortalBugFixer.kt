package club.kid7.endportalbugfixer

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class EndPortalBugFixer : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerListener(), this)
    }

    override fun onDisable() {
        //
    }
}