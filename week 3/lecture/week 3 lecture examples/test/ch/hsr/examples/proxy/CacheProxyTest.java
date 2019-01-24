package ch.hsr.examples.proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheProxyTest {

	private CacheProxy proxy;
	
	@BeforeEach
	void setup() {
		Original origin = new Original();
		proxy = new CacheProxy(origin);		
	}
	

	@Test
	void test_doAction_with_cache() {
		assertSame(proxy.doAction(), proxy.doAction(), "Proxy must cache values.");
	}

}
