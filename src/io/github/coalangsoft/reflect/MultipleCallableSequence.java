package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.AbstractSequence;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class MultipleCallableSequence<A extends SingleCallable,B extends MultipleCallableSequence<A,B>> extends AbstractSequence<A,B> implements MultipleCallable<A>{

	public MultipleCallableSequence(SequenceTool<A, B> tool, A[] values) {
		super(tool, values);
	}
	
	public Object call(Object[] os, Func<Object[], Object[]> caster) {
		if(caster != null){
			os = caster.call(os);
		}
		return call(os);
	}

	@Override
	public Object call(Object[] os) {
		for(int i = 0; i < length(); i++){
			if(at(i).getParameterCount() == os.length){
				try{
					return at(i).call(os);
				}catch(RuntimeException e){}
			}
		}
		throw new RuntimeException("No matching method found!");
	}

	@Override
	public ClassSequence[] getParameterTypes() {
		ClassSequence[] ret = new ClassSequence[length()];
		for(int i = 0; i < ret.length; i++){
			ret[i] = at(i).getParameterTypes();
		}
		return ret;
	}

	@Override
	public int[] getParameterCounts() {
		int[] ret = new int[length()];
		for(int i = 0; i < ret.length; i++){
			ret[i] = at(i).getParameterCount();
		}
		return ret;
	}
	
}
