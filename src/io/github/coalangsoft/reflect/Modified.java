package io.github.coalangsoft.reflect;

import java.lang.reflect.Modifier;

public class Modified implements IModified{
	
	private int modifiers;

	public Modified(int modifiers){
		this.modifiers = modifiers;
	}
	
	public boolean isPublic(){
		return Modifier.isPublic(modifiers);
	}
	public boolean isPrivate(){
		return Modifier.isPrivate(modifiers);
	}
	public boolean isProtected(){
		return Modifier.isProtected(modifiers);
	}
	
}
