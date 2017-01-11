package test.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.Pair;
import io.github.coalangsoft.reflect.ClassSequence;
import io.github.coalangsoft.reflect.Clss;

public class ReflectTest {
	
	public static void main(String[] args) {
		ClassSequence s = ClassSequence.make(int.class, char.class);
		System.out.println(s.matcher(ClassSequence.make(int.class, char.class, void.class))
			.find(new Func<Pair<Clss,Clss>, Boolean>() {
				
				public Boolean call(Pair<Clss, Clss> p) {
					return p.getA().base == p.getB().base;
				}
			})
		);
	}

}
