package io.github.coalangsoft.reflect;

import io.github.coalangsoft.reflect.IModified;

public interface IClass extends IModified, MultipleCallable<Constructor> {

    Methods method(String name);
    SpecificMethods getMethods(Object o, String name);

}
