package com.gmail.nossr50.config;

import com.gmail.nossr50.mcMMO;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.InputStreamReader;

public class HiddenConfig {
    private static HiddenConfig instance;
    private String fileName;
    private YamlConfiguration config;
    private boolean chunkletsEnabled;
    private int conversionRate;
    private boolean useEnchantmentBuffs;

    public HiddenConfig(String fileName) {
        this.fileName = fileName;
        load();
    }

    public static HiddenConfig getInstance() {
        if (instance == null) {
            instance = new HiddenConfig("hidden.yml");
        }

        return instance;
    }

    public void load() {
        InputStreamReader reader = mcMMO.p.getResourceAsReader(fileName);
        if (reader != null) {
            config = YamlConfiguration.loadConfiguration(reader);
            chunkletsEnabled = config.getBoolean("Options.Chunklets", true);
            conversionRate = config.getInt("Options.ConversionRate", 1);
            useEnchantmentBuffs = config.getBoolean("Options.EnchantmentBuffs", true);
        }
    }

    public boolean getChunkletsEnabled() {
        return chunkletsEnabled;
    }

    public int getConversionRate() {
        return conversionRate;
    }

    public boolean useEnchantmentBuffs() {
        return useEnchantmentBuffs;
    }
}
