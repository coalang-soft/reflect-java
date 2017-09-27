package io.github.coalangsoft.reflect;

public interface SingleCallable extends UnspecificCallable, IModified, IReflectionThing{
	
	ClassSequence getParameterTypes();
	int getParameterCount();
	
}
