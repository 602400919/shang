package cn.wh.shang.xxxx.cache;

import com.fasterxml.jackson.core.type.TypeReference;

public interface ICache<T> {

	void put(String id , T t);
	
	default void put(String id , T t, long timeoutSeconds) {
		throw new UnsupportedOperationException(ICache.class.getName()+".put(String id , T t, long timeoutSeconds)");
	}
	
	T get(String id);
	
	default T get(String id, Class<T> objType) {
		throw new UnsupportedOperationException(ICache.class.getName()+".get(String id, Class<T> objType)");
	}
	
	default T get(String id, TypeReference<T> cls) {
		throw new UnsupportedOperationException(ICache.class.getName()+".get(String id, TypeReference<T> cls)");
	}
	
	default void delete(String id) {
		throw new UnsupportedOperationException(ICache.class.getName()+".delete(String id)"); 
	}

	default void fuzzyDelete(String pattern) {
		throw new UnsupportedOperationException(ICache.class.getName()+".fuzzyDelete(String pattern)");
	}
	
	default void clear() {
		throw new UnsupportedOperationException(ICache.class.getName()+".clear()"); 
	}
	
	default boolean contains(String id) {
		throw new UnsupportedOperationException(ICache.class.getName()+".contains(String id)"); 
	}
	
}
