package io.github.coalangsoft.reflect;

import java.util.ArrayList;

public class SpecificMethods {
	
	private SpecificMethod[] array;

	public SpecificMethods(SpecificMethod[] array){
		this.array = array;
	}
	
	public SpecificMethods byName(String name){
		ArrayList<SpecificMethod> l = new ArrayList<SpecificMethod>();
		for(int i = 0; i < array.length; i++){
			SpecificMethod m = array[i];
			if(m.getName().equals(name)){
				l.add(m);
			}
		}
		return new SpecificMethods(l.toArray(array));
	}
	
	public SpecificMethods byParameterTypes(Class<?>... types){
		ArrayList<SpecificMethod> l = new ArrayList<SpecificMethod>();
		for(int i = 0; i < array.length; i++){
			SpecificMethod m = array[i];
			if(m.getParameterTypes().matches(ClassSequence.make(types))){
				l.add(m);
			}
		}
		return new SpecificMethods(l.toArray(array));
	}

	public int count() {
		return array.length;
	}

	public SpecificMethod get(int i) {
		return array[i];
	}

}
