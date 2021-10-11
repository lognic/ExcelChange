package com.log.excelchange.setting;

import com.log.excelchange.log.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SettingManager {

    public static final String SETTING_FILE = "settings.properties";
    public static final String PROP_ITEMNO_PREFIX = "itemNoPrefix";
    public static final String PROP_ITEMNO_INITIAL = "itemNoInitial";
    public static final String PROP_DATACLASS = "dataClass";
    public static final String PROP_SOURCE_SHEET_INDEX = "sourceSheetIndex";
    public static final String PROP_SOURCE_SHEET_NAME = "sourceSheetName";
    public static final String PROP_SOURCE_FORMAT = "sourceFormat";
    public static final String PROP_HEAD_ROW_NUMBER = "headRowNumber";
    public static final String PROP_SOURCE_FILE = "sourceFile";
    public static final String PROP_SOURCE_OUT_FILE = "outFile";

    public static Setting readSetting() {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(SETTING_FILE);
        try {
            properties.load(new InputStreamReader(inputStream, "UTF-8"));
            Setting setting = new Setting();
            setting.itemNoPrefix = properties.getProperty(PROP_ITEMNO_PREFIX, "YW");
            setting.itemNoInitial = Integer.valueOf(properties.getProperty(PROP_ITEMNO_INITIAL, "10000"));
            setting.dataClass = properties.getProperty(PROP_DATACLASS);
            setting.sourceSheetName = properties.getProperty(PROP_SOURCE_SHEET_NAME);
            setting.sourceSheetIndex = Integer.valueOf(properties.getProperty(PROP_SOURCE_SHEET_INDEX));
            setting.sourceFormat = Integer.valueOf(properties.getProperty(PROP_SOURCE_FORMAT));
            setting.headRowNumber = Integer.valueOf(properties.getProperty(PROP_HEAD_ROW_NUMBER));
            setting.sourceFile = properties.getProperty(PROP_SOURCE_FILE);
            setting.outFile = properties.getProperty(PROP_SOURCE_OUT_FILE);
            Log.info(setting.toString());
            return setting;
        } catch (Exception e) {
            e.printStackTrace();
            Log.info(e.getMessage());
        }
        return null;
    }


}
