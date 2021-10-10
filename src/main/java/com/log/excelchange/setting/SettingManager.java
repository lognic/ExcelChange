package com.log.excelchange.setting;

import com.log.excelchange.log.Log;

import java.io.InputStream;
import java.util.Properties;

public class SettingManager {

    public static final String SETTING_FILE = "settings.properties";
    public static final String PROP_ITEMNO_PREFIX = "itemNoPrefix";
    public static final String PROP_ITEMNO_INITIAL = "itemNoInitial";
    public static final String PROP_DATACLASS = "dataClass";
    public static final String PROP_SOURCE_SHEET_INDEX = "sourceSheetIndex";
    public static final String PROP_SOURCE_SHEET_NAME = "sourceSheetName";
    public static final String PROP_SOURCE_FORMAT = "sourceFormat";

    public static Setting readSetting() {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(SETTING_FILE);
        try {
            properties.load(inputStream);
            Setting setting = new Setting();
            setting.itemNoPrefix = properties.getProperty(PROP_ITEMNO_PREFIX, "YW");
            setting.itemNoInitial = Integer.valueOf(properties.getProperty(PROP_ITEMNO_INITIAL, "10000"));
            setting.dataClass = properties.getProperty(PROP_DATACLASS);
            setting.sourceSheetName = properties.getProperty(PROP_SOURCE_SHEET_NAME);
            setting.sourceSheetIndex = Integer.valueOf(properties.getProperty(PROP_SOURCE_SHEET_INDEX));
            setting.sourceFormat = Integer.valueOf(properties.getProperty(PROP_SOURCE_FORMAT));
            Log.info(setting.toString());
            return setting;
        } catch (Exception e) {
            e.printStackTrace();
            Log.info(e.getMessage());
        }
        return null;
    }


}