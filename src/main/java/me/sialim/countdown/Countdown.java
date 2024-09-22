package me.sialim.countdown;

import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public final class Countdown extends JavaPlugin {
    private long days, hours, minutes, seconds;

    @Override
    public void onEnable() {
        new CountdownPlaceholder(this).register();
        getLogger().info("Countdown Plugin Enabled!");
        getServer().getScheduler().runTaskTimer(this, this::updateCountdown, 0L, 20L);
    }

    private void updateCountdown() {
        LocalDateTime targetDate = LocalDateTime.of(2025, 3, 18, 0, 0);
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Chicago"));

        long totalSeconds = ChronoUnit.SECONDS.between(now, targetDate);
        days = totalSeconds / 86400;
        hours = (totalSeconds % 86400) / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = totalSeconds % 60;
    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }
}
