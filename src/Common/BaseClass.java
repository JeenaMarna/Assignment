package Common;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
	public static String landing_page_title;
	public static String landing_pass_message;
	public static String landing_fail_message;
	public static String from_city;
	public static String to_city;
	public static String search_page_title;
	public static String search_pass_message;
	public static String search_fail_message;
	public static String url;
	public static String filter_pass_message;
	public static String filter_fail_message;
	public static void getValues() throws Exception {
		Properties data=new Properties();
		System.out.println(data);
		FileInputStream file= new FileInputStream(".\\Test Data\\config.properties");
		System.out.println(file);
		data.load(file);
		url=data.getProperty("url");
		landing_page_title=data.getProperty("landing_page_title"); 
		landing_pass_message=data.getProperty("landing_pass_message");
		landing_fail_message=data.getProperty("landing_fail_message");
		from_city=data.getProperty("from_city");
		to_city=data.getProperty("to_city");
		search_page_title=data.getProperty("search_page_title");
		search_pass_message=data.getProperty("search_pass_message");
		search_fail_message=data.getProperty("search_fail_message");
		filter_pass_message=data.getProperty("filter_pass_message");
		filter_fail_message=data.getProperty("filter_fail_message");
	}
}
