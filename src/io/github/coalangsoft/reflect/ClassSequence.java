package io.github.coalangsoft.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.Pair;
import io.github.coalangsoft.lib.sequence.AbstractSequence;
import io.github.coalangsoft.lib.sequence.SequenceTool;

public class ClassSequence extends AbstractSequence<Clss,ClassSequence>{
	
	public ClassSequence(Clss... array) {
		super(new SequenceTool<Clss,ClassSequence>(
				new Func<Clss[],ClassSequence>(){

					@Override
					public ClassSequence call(Clss[] p) {
						return new ClassSequence(p);
					}
					
				},
				new Func<Integer, Clss[]>(){

					@Override
					public Clss[] call(Integer p) {
						return new Clss[p];
					}
					
				}
				
			), array);
	}
	
	public static ClassSequence make(Class<?>... cs){
		Clss[] arr = new Clss[cs.length];
		for(int i = 0; i < cs.length; i++){
			arr[i] = new Clss(cs[i]);
		}
		return new ClassSequence(arr);
	}

	public boolean matches(Clss... types) {
		if(types.length != getRaw().length){
			return false;
		}
		return matcher(types).find(new Func<Pair<Clss, Clss>, Boolean>(){

			public Boolean call(Pair<Clss, Clss> p) {
				return p.getA().base == p.getB().base;
			}
			
		});
	}

	public boolean matches(ClassSequence s) {
		return matches(s.getRaw());
	}
	
	public Clss bySimpleName(String name){
		for(int i = 0; i < getRaw().length; i++){
			Clss c = getRaw()[i];
			if(c.getSimpleName().equals(name)){
				return c;
			}
		}
		return null;
	}

}
