package test.reflect;

import io.github.coalangsoft.lib.data.Func;
import io.github.coalangsoft.lib.data.Pair;
import io.github.coalangsoft.reflect.ClassSequence;
import io.github.coalangsoft.reflect.Clss;

public class ReflectTest {
	
	public static void a(String s){
		System.out.println("String");
	}
	public static void a(int s){
		System.out.println("Int");
	}
	
	public static void main(String[] args) {
		Clss c = new Clss(ReflectTest.class);
		c.getMethods(null, "a").call(new Object[]{"ff"});
	}

}
