package com.reach;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class CommonConfig {
    public static double createConfigDouble(Configuration config, String category, String name, String comment, double def) {

        Property prop = config.get(category, name, def);
        prop.setComment(comment);
        return prop.getDouble();
    }

    public static double reach = 2.5D;
    public static void loadFromConfig(Configuration config) {
        reach = createConfigDouble(config, "General", "reach", "The player reach distance (in blocks) (1.5 by default)", 2.5D);
    }
}
