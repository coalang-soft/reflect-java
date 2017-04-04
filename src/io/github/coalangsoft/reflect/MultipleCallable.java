package io.github.coalangsoft.reflect;

public interface MultipleCallable<T extends SingleCallable> extends UnspecificCallable{

	ClassSequence[] getParameterTypes();
	int[] getParameterCounts();
	int length();
	T at(int i);
	
}
