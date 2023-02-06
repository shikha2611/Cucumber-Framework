package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import constants.FileConstants;

public class PropertyReader {

	public static String readAppLaunchUrl(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.app_launch_url_path);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readbrowserType(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.browser_name_path);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readErrorMsg(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.error_msg_path);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readLoginUsernamePassword(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.login_data_path);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readpageTitle(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.page_Titles);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readUserMenu(String key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.user_Menu);
		prop.load(fr);
		String value = prop.getProperty(key);
		return value;
	}

	public static String readPublisherFeedChoices(String Key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.my_profile_feed_choices);
		prop.load(fr);
		String value = prop.getProperty(Key);
		return value;
	}

	public static String readMySettingsOptions(String Key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.mySetting_options);
		prop.load(fr);
		String value = prop.getProperty(Key);
		return value;
	}

	public static String readAppMenuOptions(String Key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.app_Menu_Options);
		prop.load(fr);
		String value = prop.getProperty(Key);
		return value;
	}



	public static String readKeywordLookup(String Key) throws IOException {
		Properties prop = new Properties();
		FileReader fr = new FileReader(FileConstants.keyword_lookup);
		prop.load(fr);
		String value = prop.getProperty(Key);
		return value;

	}

}
