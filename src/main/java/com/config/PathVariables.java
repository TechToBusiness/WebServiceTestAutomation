package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class PathVariables {
    private static PathVariables objPV;
    public static String baseDir = System.getProperty("user.dir");
    public static String configValue;
    public static HashMap<String, String> hm;

    private PathVariables() throws IOException {

            //this.hm = getProperties();

    }

    public static PathVariables getPathVariableObject()
    {
        if(objPV == null) {
            try {
                objPV = new PathVariables();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objPV;
    }

    public void getProperties()
    {
        String result = "";
        InputStream is;
        try
        {
            Properties prop = new Properties();
            String proFileName = "config.properties";
            is = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");

            if(is != null)
            {
                prop.load(is);
            }
            else
                throw new FileNotFoundException("Property File " + proFileName + " not found");

//            hm1.put("appType", prop.getProperty("appType"));
//            hm1.put("appURL", prop.getProperty("appURL"));
//            if(prop.getProperty("appType").equals("jar"))
//            {
//                hm1.put("appJARLocation",prop.getProperty("appJARLocation"));
//                hm1.put("jarName", prop.getProperty("jarName"));
//            }

//            System.setProperties(prop);

            System.setProperty("appType", prop.getProperty("appType"));
            System.setProperty("appURL", prop.getProperty("appURL"));
            if(System.getProperty("appType").equals("jar"))
            {
                System.setProperty("appJARLocation",prop.getProperty("appJARLocation"));
                System.setProperty("jarName", prop.getProperty("jarName"));
            }


        }catch (Exception e) {
            System.out.println("Exception :" + e);
        }


    }
}
