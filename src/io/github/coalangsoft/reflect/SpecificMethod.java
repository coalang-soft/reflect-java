package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;

import java.lang.reflect.Method;

public class SpecificMethod extends Modified implements Func<Object[], Object>, SingleCallable{

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
	
	public void setAccessible(boolean b){
		method.setAccessible(b);
	}
	
	public Object call(Object[] p, Func<Object[], Object[]> cast) {
		if(cast != null){
			p = cast.call(p);
		}
		return call(p);
	}

	public String getName() {
		return method.getName();
	}

	public ClassSequence getParameterTypes() {
		return ClassSequence.make(method.getParameterTypes());
	}

	public int getParameterCount() {
		return method.getParameterCount();
	}

	@Override
	public Object call(Object[] p) {
		try {
			if(isPublic()){
				method.setAccessible(true);
			}
			return method.invoke(object, p);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
