package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;

public class MapUtil {
    /**
     * @ensures \result == (\forAll K x,y; map.containsKey(x) && map.containsKey(y) && x != y; map.get(x) != map.get(y));
     */
	/** @pure */public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	int count = 0;
        Set<K> set = map.keySet();
        Collection<V> setv = map.values();
        for (K set2: set) {
        	for (V setv2: setv) {
        		if (setv2 == map.get(set2)) {
        			count++;
        		}
        		if (count > 1) {
        			return false;
        		}
        	}
        	count = 0;
        }
        return true;
    }
	
	/**
	 * @ensures \result == (\forAll V y; map.containsValue(y); range.containsValue(y); (\exists K x; map.containsKey(x); map.get(x) == y));
	 */
	/** @pure */public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		for (V range2: range) {
		 	if (!map.containsValue(range2)) {
		 		return false;
		 	}
		}
		return true;
	}
	
	/**
	 * @ensures \forAll K x; result.contains(x);
	 */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> output = new HashMap<V, Set<K>>();
        Set<K> set = map.keySet();
        for (K set2:set) {
        	V val = map.get(set2);
        	if (output.containsKey(val)) {
        		Set<K> val2 = output.get(val);
        		val2.add(set2);
        		output.put(val, val2);
        	} else {
        		output.put(val, new HashSet<K>(Arrays.asList(set2)));
        	}
        }
        return output;
	}
    
    /**
     * @ensures \forAll K x; \result.contains(x);
     */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> output = new HashMap<V, K>();
        Set<K> set = map.keySet();
        Collection<V> setv = map.values();
        if (!(isOneOnOne(map) && isSurjectiveOnRange(map, new HashSet<V>(setv)))) {
        	return null;
        }
        for (K set2:set) {
        	V val = map.get(set2);
        	output.put(val, set2);
        }
        return output;
	}
	
	/**
	 * @ensures \result == (\forAll K x; (\exists V y; f.get(x) == y && g.values().contains(y)));
	 */
	/** @pure */public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        Collection<V> setv = f.values();
        for (V setv2:setv) {
        	if (!g.containsKey(setv2)) {
        		return false;
        	}
        }
        return true;
	}
	
	/**
	 * @ensures \result == (\forAll K x; (\exists V y; f.get(x) == y; g.values().contains(y)));
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        if (!compatible(f, g)) {
        	return null;
        }
        Map<K, W> output = new HashMap<K, W>();
        Set<K> set = f.keySet();
        Set<V> setv = g.keySet();
        for (K set2:set) {
        	for (V setv2:setv) {
        		if (setv2 == f.get(set2)) {
        			output.put(set2, g.get(setv2));
        		}
        	}
        }
        return output;
	}
}