package ch.hsr.examples.proxy;

public class CacheProxy extends AbstractOriginal {

	private final AbstractOriginal original;
	private Object cache;
	
	public CacheProxy(AbstractOriginal original) {
		this.original = original;
	}
	
	@Override
	public Object doAction() {
		if (cache == null) {
			cache = original.doAction();
		}
		return cache;
	}
}
