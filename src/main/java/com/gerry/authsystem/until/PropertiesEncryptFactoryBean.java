package com.gerry.authsystem.until;

import java.util.Properties;
import org.springframework.beans.factory.FactoryBean;

/**
 * spring数据源配置c3p0数据库用户名密码加密类
 * @author Gerry_Pang
 */
public class PropertiesEncryptFactoryBean implements FactoryBean{
	private Properties properties;  
    
    public Object getObject() throws Exception {  
        return getProperties();  
    }  
  
    public Class getObjectType() {  
        return java.util.Properties.class;  
    }  
  
    public boolean isSingleton() {  
        return true;  
    }  
  
    public Properties getProperties() {  
        return properties;  
    }  
  
    public void setProperties(Properties inProperties) {  
        this.properties = inProperties;  
        String originalUsername = properties.getProperty("user");  
        String originalPassword = properties.getProperty("password");  
        if (originalUsername != null){  
            String newUsername = deEncryptUsername(originalUsername);  
            properties.put("user", newUsername);  
        }  
        if (originalPassword != null){  
            String newPassword = deEncryptPassword(originalPassword);  
            properties.put("password", newPassword);  
        }  
    }  
      
    private String deEncryptUsername(String originalUsername){  
        return deEncryptString(originalUsername);  
    }  
      
    private String deEncryptPassword(String originalPassword){  
        return deEncryptString(originalPassword);  
    }  
    
    //解密 
    private  String deEncryptString(String originalString){  
        StringBuilder newString = new StringBuilder();  
        for (int i = 0; i < originalString.length(); i++) {  
            char eachChar= originalString.charAt(i);  
            char newChar = (char)(eachChar + i);  
            newString.append(newChar);  
        }  
        return newString.toString();  
    } 
    
    private String encryptString(String originalString){  
        StringBuilder newString = new StringBuilder();  
        for (int i = 0; i < originalString.length(); i++) {  
            char eachChar= originalString.charAt(i);  
            char newChar = (char)(eachChar - i);  
            newString.append(newChar);  
        }  
        return newString.toString();  
    } 
    
//    public static void main(String[] args) {
//    	System.out.println("用户名:" + encryptString("root"));
//    	System.out.println("密码:" + encryptString("root"));
//	}
}
