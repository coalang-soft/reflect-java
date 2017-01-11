package io.github.coalangsoft.reflect;

public class Clss extends Modified{
	
	public final Class<?> base;
	
	public static Clss make(String name) throws ClassNotFoundException{
		return new Clss(Class.forName(name));
	}
	public Clss(Class<?> c){
		super(c.getModifiers());
		this.base = c;
	}
	
	public Methods method(String name){
		return new Methods(this, name);
	}
	
	public SpecificMethods getDeclaredMethods(Object o, String name){
		return method(name).listSpecific(o, true);
	}
	
	public SpecificMethods getMethods(Object o, String name){
		return method(name).listSpecific(o, false);
	}
	
	public ClassSequence getDeclaredClasses() {
		Class<?>[] list = base.getDeclaredClasses();
		Clss[] ret = new Clss[list.length];
		for(int i = 0; i < list.length; i++){
			ret[i] = new Clss(list[i]);
		}
		return new ClassSequence(ret);
	}

	public String getSimpleName() {
		return base.getSimpleName();
	}
	public boolean isPrimitive() {
		return base.isPrimitive();
	}
	public boolean isArray() {
		return base.isArray();
	}
	public boolean isInterface() {
		return base.isInterface();
	}
	public boolean isInstance(Object value) {
		return base.isInstance(value);
	}
	@Override
	public String toString() {
		return base.toString();
	}
	public String getName() {
		return base.getName();
	}
	
}
