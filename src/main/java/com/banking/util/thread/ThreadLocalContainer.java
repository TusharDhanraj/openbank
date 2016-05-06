/**
 * Container to store thread local variables
 */
package com.banking.util.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tbhendar
 *
 */
public class ThreadLocalContainer {
	private ThreadLocalContainer() {
	}

	/**
	 * Thread local
	 */
	private static ThreadLocal<Map<String, Object>> threadLocalMap = new ThreadLocal<Map<String, Object>>();

	/**
	 * gets the value
	 * 
	 * @param key
	 * @return
	 */
	public static Object getObject(String key) {
		Object value = null;
		if (threadLocalMap.get() != null) {
			value = threadLocalMap.get().get(key);
		}
		return value;
	}

	/**
	 * Stores key value pair
	 * 
	 * @param key
	 * @param value
	 */
	public static void setObject(String key, Object value) {
		Map<String, Object> map = threadLocalMap.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			threadLocalMap.set(map);
		}
		threadLocalMap.get().put(key, value);
	}

	/**
	 * Clear the thread variables
	 */
	public static void clear() {
		threadLocalMap.remove();
	}
}
