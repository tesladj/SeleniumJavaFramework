package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
	}

	public static void getProperties(){

		try {


			InputStream input = new FileInputStream(ProjectPath + "/src/test/java/config/config.properties");
			try {
				prop.load(input);
				String browser = prop.getProperty("browser");
				System.out.println(browser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setProperties(){

		try {
			OutputStream output = new FileOutputStream(ProjectPath + "/src/test/java/config/config.properties");
			prop.setProperty("browser", "chrome");
			try {
				prop.store(output, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
