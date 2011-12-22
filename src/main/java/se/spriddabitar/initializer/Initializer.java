package se.spriddabitar.initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Initializer
{

	public  <T> T setValues(Class<T> beanClazz) throws InstantiationException, 
	IllegalAccessException, 
	IllegalArgumentException, 
	InvocationTargetException 
	{
		T bean = beanClazz.newInstance();
		
		List<Method>  setters = getSetters(beanClazz);
		
		for(Method setter : setters)
		{
			Object value = getParameter(setter);
			invokeSetterOnBean(bean, setter, value);
		}
			
		return bean;
	}

	
	private Object getParameter(Method setter) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
     	Class<?> parameter = setter.getParameterTypes()[0];
     	return new ValueFactory().getValueFor(parameter);
	}


	private <T> void invokeSetterOnBean(T bean, Method setter, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		setter.invoke(bean, value);
	}

	
    public  List<Method> getSetters(Class<?> clazz) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
    {
        List<Method> result = new ArrayList<Method>();
        fillListRecursively(clazz, result);
        return result;
    }
    
    private void fillListRecursively(Class<?> clazz, List<Method> allMethods) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
    {
        if(clazz.getSuperclass() != Object.class)
        	fillListRecursively(clazz.getSuperclass(), allMethods);
        
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods)
        {
        	if(isSetter(method))
            {	
                allMethods.add(method);
            }
        }
    }


	private boolean isSetter(Method method) {
		return !Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length==1 && 
				method.getName().startsWith("set") && Modifier.isPublic(method.getModifiers());
	}
}
