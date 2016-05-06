/**
 * 
 */
package com.banking.comparator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tbhendar
 *
 */
public class Constants {
	static String RBS_CONSUMER_KEY = "js5e4d1zkgwhib13zwknyynunlmxq3avghvukaaf";
	static String NBD_CONSUMER_KEY = "hqjxp0mjkqolx3lxuem1avnstb3q3k3bzh3kmkw3";
	private static final String RBS_BASE_URL_TOKEN = "https://apisandbox.openbankproject.com";
	private static final String NBD_BASE_URL_TOKEN = "https://enbdg.openbankproject.com";
	private static String RBS_BASE_URL_API_URL = "https://apisandbox.openbankproject.com/obp/v2.0.0";
	private static String NBD_BASE_URL_API_URL = "https://enbdg.openbankproject.com/obp/v2.0.0";
	static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("RBS_CONSUMER_KEY", RBS_CONSUMER_KEY);
		map.put("NBD_CONSUMER_KEY", NBD_CONSUMER_KEY);
		map.put("RBS_BASE_URL_TOKEN", RBS_BASE_URL_TOKEN);
		map.put("NBD_BASE_URL_TOKEN", NBD_BASE_URL_TOKEN);
		map.put("RBS_BASE_URL_API_URL", RBS_BASE_URL_API_URL);
		map.put("NBD_BASE_URL_API_URL", NBD_BASE_URL_API_URL);
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static void setMap(Map<String, String> map) {
		Constants.map = map;
	}
}
