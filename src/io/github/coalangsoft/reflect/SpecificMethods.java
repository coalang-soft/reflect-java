package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.sequence.ModifiableSequence;
import io.github.coalangsoft.lib.sequence.SequenceTool;

import java.util.ArrayList;

public class SpecificMethods extends ModifiableSequence<SpecificMethod, SpecificMethods>{
	
	public SpecificMethods(SpecificMethod[] array){
		super(new SequenceTool<SpecificMethod, SpecificMethods>(
					new Func<SpecificMethod[],SpecificMethods>(){

						@Override
						public SpecificMethods call(SpecificMethod[] p) {
							return new SpecificMethods(p);
						}
						
					},
					new Func<Integer, SpecificMethod[]>(){

						@Override
						public SpecificMethod[] call(Integer p) {
							return new SpecificMethod[p];
						}
						
					}
					
				), array);
	}
	
	public SpecificMethods byName(String name){
		ArrayList<SpecificMethod> l = new ArrayList<SpecificMethod>();
		for(int i = 0; i < values.length; i++){
			SpecificMethod m = values[i];
			if(m.getName().equals(name)){
				l.add(m);
			}
		}
		return new SpecificMethods(l.toArray(values));
	}
	
	public SpecificMethods byParameterTypes(Class<?>... types){
		ArrayList<SpecificMethod> l = new ArrayList<SpecificMethod>();
		for(int i = 0; i < values.length; i++){
			SpecificMethod m = values[i];
			if(m.getParameterTypes().matches(ClassSequence.make(types))){
				l.add(m);
			}
		}
		return new SpecificMethods(l.toArray(values));
	}

}
