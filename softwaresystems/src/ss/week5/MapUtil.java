package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//import java.util.Iterator;
import java.util.Collection;

public class MapUtil {
	
	/**
	 * @requires map != null;
	 * @return boolean
	 * @pure
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	//Collection<K> values = map.values();
    	Set<K> jk = map.keySet();
    	Collection<V> jv = map.values();
    	int counter;
    	//Iterator <V> i = jk.iterator();
    	for (V i: jv) {
    		counter = 0;
    		for (K j: jk) {
    			if (i == map.get(j)) {
    				counter++;
    			}
    		}
    		if (counter != 1) {
    			return false;
    		}
    	}
        return true;
    }
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // TODO: implement, see exercise P-5.2
        return false;
    }
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
