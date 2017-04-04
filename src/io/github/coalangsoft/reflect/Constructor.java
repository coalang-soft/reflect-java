package io.github.coalangsoft.reflect;

import java.lang.reflect.InvocationTargetException;

public class Constructor extends Modified implements SingleCallable{

	private java.lang.reflect.Constructor<?> c;

	public Constructor(java.lang.reflect.Constructor<?> c) {
		super(c.getModifiers());
		this.c = c;
	}

	@Override
	public Object call(Object[] p) {
		try {
			return c.newInstance(p);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ClassSequence getParameterTypes() {
		return ClassSequence.make(c.getParameterTypes());
	}

	@Override
	public int getParameterCount() {
		return c.getParameterCount();
	}

	public static Constructor[] cast(
			java.lang.reflect.Constructor<?>[] constructors) {
		Constructor[] cs = new Constructor[constructors.length];
		for(int i = 0; i < cs.length; i++){
			cs[i] = new Constructor(constructors[i]);
		}
		return cs;
	}

	public Clss getDeclaringClass() {
		return new Clss(c.getDeclaringClass());
	}

}
