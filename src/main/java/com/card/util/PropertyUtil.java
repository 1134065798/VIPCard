package com.card.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
    private static Map map = null;

    private static void loadFile() {
        map = new HashMap();
        try {
            Properties p = new Properties();
            p.load(PropertyUtil.class.getClassLoader().getResourceAsStream("config.properties"));
            Iterator it = p.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = p.getProperty(key);
                map.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue_String(String str) {
        if (map == null) {
            loadFile();
        }
        return (String) map.get(str);
    }

    public static int getValue_Int(String str) {
        Integer a;
        if (map == null) {
            loadFile();
        }
        a=new Integer((String) map.get(str));
        return a;
    }
}
