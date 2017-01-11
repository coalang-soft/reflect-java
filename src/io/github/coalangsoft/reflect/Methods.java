package io.github.coalangsoft.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Methods {

	private Clss clss;
	private String name;

	public Methods(Clss clss, String name) {
		this.clss = clss;
		this.name = name;
	}

	public SpecificMethods listSpecific(Object o, boolean declared){
		Method[] ms = declared ? clss.base.getDeclaredMethods() : clss.base.getMethods();
		if(name == null){
			SpecificMethod[] ret = new SpecificMethod[ms.length];
			for(int i = 0; i < ms.length; i++){
				ret[i] = new SpecificMethod(o, ms[i]);
			}
			return new SpecificMethods(ret);
		}else{
			ArrayList<SpecificMethod> l = new ArrayList<SpecificMethod>();
			for(int i = 0; i < ms.length; i++){
				Method m = ms[i];
				if(m.getName().equals(name)){
					l.add(new SpecificMethod(o, m));
				}
			}
			return new SpecificMethods(l.toArray(new SpecificMethod[0]));
		}
	}

}
