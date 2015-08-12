package org.dayspics.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.dayspics.util.Utils;

public class ConfigurationManager {
	/**
     * The property name used to specify an URL to the configuration
     * property file to be used for the created the framework instance.
    **/
	public static final String CONFIG_PROPERTIES_PROP = "felix.config.properties";
	/**
     * The default name used for the configuration properties file.
    **/
    public static final String CONFIG_PROPERTIES_FILE_VALUE = "config.properties";
	/**
     * Name of the configuration directory.
     */
    public static final String CONFIG_DIRECTORY = "conf";
    
	public static Map<String, String> loadConfigProperties(){
        // The config properties file is either specified by a system
        // property or it is in the conf/ directory of the Felix
        // installation directory.  Try to load it from one of these
        // places.
    	//加载conf/目录下的配置文件
    	
        // See if the property URL was specified as a property.
        URL propURL = null;
        String custom = System.getProperty(CONFIG_PROPERTIES_PROP);
        if (custom != null){
            try{
                propURL = new URL(custom);
            }catch (MalformedURLException ex){
                System.err.print("Main: " + ex);
                return null;
            }
        }else{
            // Determine where the configuration directory is by figuring
            // out where felix.jar is located on the system class path.
        	//通过felix.jar所在系统class path来确定配置文件所在目录
            File confDir = null;
            //获取所有classpath
            String classpath = System.getProperty("java.class.path");
            //获取felix.jar第一次出现的位置
            int index = classpath.toLowerCase().indexOf("felix.jar");
            //从index开始查找";"最后一次出现的位置，index往前查找，
            int start = classpath.lastIndexOf(File.pathSeparator, index) + 1;
            if (index >= start){
                // Get the path of the felix.jar file.
            	//此时为felix.jar文件的真正位置
                String jarLocation = classpath.substring(start, index);
                // Calculate the conf directory based on the parent
                // directory of the felix.jar directory.
                confDir = new File(
                    new File(new File(jarLocation).getAbsolutePath()).getParent(),
                    CONFIG_DIRECTORY);
            }else{
                // Can't figure it out so use the current directory as default.
                confDir = new File(System.getProperty("user.dir"), CONFIG_DIRECTORY);
            }
            try{
            	//获取config.properties文件
                propURL = new File(confDir, CONFIG_PROPERTIES_FILE_VALUE).toURL();
            }catch (MalformedURLException ex){
                System.err.print("Main: " + ex);
                return null;
            }
        }

        // Read the properties file.
        Properties props = new Properties();
        InputStream is = null;
        try{
            // Try to load config.properties.
            is = propURL.openConnection().getInputStream();
            props.load(is);
            is.close();
        }catch (Exception ex){
            // Try to close input stream if we have one.
            try{
                if (is != null) is.close();
            }catch (IOException ex2){
                // Nothing we can do.
            }

            return null;
        }

        // Perform variable substitution for system properties and
        // convert to dictionary.
        Map<String, String> map = new HashMap<String, String>();
        for (Enumeration e = props.propertyNames(); e.hasMoreElements(); ){
            String name = (String) e.nextElement();
            map.put(name,Utils.substVars(props.getProperty(name), name, null, props));
        }

        return map;
    }
	
	public static void main(String[] args) {
		
	}

}
