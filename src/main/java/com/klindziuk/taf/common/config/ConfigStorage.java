package com.klindziuk.taf.common.config;

import com.klindziuk.taf.common.util.StringUtil;
import com.klindziuk.taf.common.util.YamlUtil;

/**
 * Config storage
 */
public final class ConfigStorage {

    private static Config config;

    static {
        String path = String.format("%s/src/main/resources/properties/%s.yml", System.getProperty("user.dir"),
                System.getProperty("profileName"));
        config = YamlUtil.fromYaml(StringUtil.updatePath(path), Config.class);
    }

    private ConfigStorage() {
    }

    public static Config getConfig() {
        return config;
    }
}
