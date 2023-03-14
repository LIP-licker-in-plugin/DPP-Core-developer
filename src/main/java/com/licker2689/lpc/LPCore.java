package com.licker2689.lpc;

import com.licker2689.lpc.api.discord.DiscordAPI;
import com.licker2689.lpc.api.placeholder.LPHManager;
import com.licker2689.lpc.api.twitch.TwitchAPI;
import com.licker2689.lpc.commands.LPCCommand;
import com.licker2689.lpc.enums.PluginName;
import com.licker2689.lpc.utils.ConfigUtils;
import com.licker2689.lpc.utils.PluginUtil;
import com.licker2689.lpc.utils.SchedulerUtils;
import com.earth2me.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class LPCore extends JavaPlugin {
    private static LPCore plugin;
    public YamlConfiguration config;
    public Logger log;
    public final String prefix = "§f[ §eLPC §f] ";
    public final Map<PluginName, JavaPlugin> enabledPlugins = new HashMap<>();
    public LPHManager lphm;
    public Essentials ess;
    public TwitchAPI tapi;

    public static LPCore getInstance() {
        return plugin;
    }

    public Map<PluginName, JavaPlugin> getEnabledPlugins() {
        return enabledPlugins;
    }

    @Override
    public void onEnable() {
        plugin = this;
        log = getLogger();
        log.info(prefix + "LP-Core 플러그인 활성화.");
        config = ConfigUtils.loadDefaultPluginConfig(plugin);
        lphm = new LPHManager();
        PluginUtil.loadALLPlugins();
        if (config.getBoolean("Settings.use-twitch-api")) {
            TwitchAPI.init();
        } else {
            log.warning(prefix + "TwitchAPI 사용이 비활성화 되어있습니다.");
        }
        if (config.getBoolean("Settings.use-discord-api")) {
            DiscordAPI.init();
        } else {
            log.warning(prefix + "DiscordAPI 사용이 비활성화 되어있습니다.");
        }
        Plugin pl = getServer().getPluginManager().getPlugin("Essentials");
        if (pl == null) {
            getLogger().warning("Essentials 플러그인이 설치되어있지 않습니다.");
            getLogger().warning("MoneyAPI 사용 불가.");
            return;
        } else {
            ess = (Essentials) pl;
        }
        Bukkit.getScheduler().runTaskLater(plugin, () -> enabledPlugins.keySet().forEach(SchedulerUtils::initUpdateChecker), 1200L);
        getCommand("lpc").setExecutor(new LPCCommand());
    }

    @Override
    public void onDisable() {
        log.info(prefix + "LP-Core 플러그인 비활성화.");
        ConfigUtils.savePluginConfig(plugin, config);
    }
}
