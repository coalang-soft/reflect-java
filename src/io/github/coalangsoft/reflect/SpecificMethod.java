package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;

import java.lang.reflect.Method;

public class SpecificMethod extends Modified implements Func<Object[], Object>{

	private Method method;
	private Object object;
	
	public SpecificMethod(Object o, Method method) {
		super(method.getModifiers());
		this.method = method;
		this.object = o;
	}
	
	public SpecificMethod forObject(Object o){
		return new SpecificMethod(o, method);
	}
	
	public Object call(Object[] p) {
		try {
			return method.invoke(object, p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Object getName() {
		return method.getName();
	}

	public ClassSequence getParameterTypes() {
		return ClassSequence.make(method.getParameterTypes());
	}

}
