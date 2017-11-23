package io.github.coalangsoft.reflect;

public class CasterImpl implements Caster{
	
	public Object[] cast(Object[] arr, ClassSequence ptypes) {
        for(int i = 0; i < ptypes.length(); i++){
            if(ptypes.at(i).isPrimitive()){
                castPrimitive(i, arr, ptypes.at(i).getSimpleName(), arr[i]);
            }else if(ptypes.at(i).isArray()){
                castArray(i, arr, ptypes.at(i), arr[i]);
            }else if(ptypes.at(i).base == Boolean.class && arr[i] instanceof Number){
                arr[i] = ((Number)arr[i]).intValue() == 1;
            }/*else{
                if(ptypes[i].isInterface()){
                    if(!ptypes[i].isInstance(args[i].getValue()) && args[i] instanceof Func){
                        if(ptypes[i].method(null).listSpecific(object, true).length() == 1){
                            Class<?> iface = ptypes[i].base;
                            String name = iface.getDeclaredMethods()[0].getName();
                            arr[i] = Proxy.newProxyInstance(iface.getClassLoader(), new Class<?>[]{iface}, new SingleInvocationHandler(vm, name, args[i]));
                            continue;
                        }
                    }
                }
                arr[i] = ptypes[i].base.cast(args[i].getValue());
            }*/
        }
        return arr;
    }

	private void castPrimitive(int i, Object[] arr, String type, Object value) {
		switch (type) {
		case "byte":
			arr[i] = ((Number) value).byteValue();
			break;
		case "short":
			arr[i] = ((Number) value).shortValue();
			break;
		case "int":
			arr[i] = ((Number) value).intValue();
			break;
		case "long":
			arr[i] = ((Number) value).longValue();
			break;

		case "float":
			arr[i] = ((Number) value).floatValue();
			break;
		case "double":
			arr[i] = ((Number) value).doubleValue();
			break;

		case "char":
			arr[i] = ((Character) value).charValue();
			break;
		case "boolean":
			arr[i] = ((Number) value).intValue() == 1;
			break;

		default:
			throw new RuntimeException("Unknown primitive: " + type);
		}
	}
	
	private static void castArray(int i, Object[] arr, Clss at, Object object) {
		throw new RuntimeException("Array cast..");
	}

}
