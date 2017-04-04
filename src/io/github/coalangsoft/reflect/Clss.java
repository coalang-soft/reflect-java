package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.reflect.CustomClassFinder;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class Clss extends MultipleCallableSequence<Constructor, Clss>{
	
	public final Class<?> base;
	
	public static Clss make(String name, CustomClassFinder cf) throws ClassNotFoundException{
		return new Clss(cf.find(name));
	}
	public static Clss make(String name) throws ClassNotFoundException{
		return new Clss(Class.forName(name));
	}
	public Clss(Class<?> c) {
		super(new SequenceTool<Constructor,Clss>(
				new Func<Constructor[],Clss>(){

					@Override
					public Clss call(Constructor[] p) {
						if(p.length == 0){
							throw new RuntimeException("At least one argument required!");
						}
						return p[0].getDeclaringClass();
					}
					
				},
				new Func<Integer, Constructor[]>(){

					@Override
					public Constructor[] call(Integer p) {
						return new Constructor[p];
					}
					
				}
				
			), Constructor.cast(c.getConstructors()));
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
	
	@Override
	public ClassSequence[] getParameterTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int[] getParameterCounts() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
