package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;

public abstract class SingleCaster implements Func<Object[], Object[]>{

	@Override
	public Object[] call(Object[] p) {
		Object[] n = new Object[p.length];
		for(int i = 0; i < n.length; i++){
			n[i] = cast(p[i]);
		}
		return n;
	}

	protected abstract Object cast(Object object);

}
