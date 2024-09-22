package me.sialim.countdown;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class CountdownPlaceholder extends PlaceholderExpansion {
    private final Countdown plugin;

    public CountdownPlaceholder(Countdown plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "countdown";
    }

    @Override
    public @NotNull String getAuthor() {
        return "sialim";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if ("to_march_18th".equals(identifier)) {
            return plugin.getDays() + " days : " + plugin.getHours() + " hours : " +
                    plugin.getMinutes() + " minutes : " + plugin.getSeconds() + " seconds";
        }
        return null;
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String identifier) {
        if ("to_march_18th".equals(identifier)) {
            return plugin.getDays() + " days : " + plugin.getHours() + " hours : " +
                    plugin.getMinutes() + " minutes : " + plugin.getSeconds() + " seconds";
        }
        return null;
    }
}
