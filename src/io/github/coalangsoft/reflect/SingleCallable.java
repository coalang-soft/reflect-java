package io.github.coalangsoft.reflect;

public interface SingleCallable extends UnspecificCallable{
	
	ClassSequence getParameterTypes();
	int getParameterCount();
	
}
