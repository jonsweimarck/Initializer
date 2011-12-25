package se.spriddabitar.initializer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Initializer
{

	public  <T> T setValues(Class<T> beanClazz) 
	throws InstantiationException, 
	IllegalAccessException, 
	IllegalArgumentException, 
	InvocationTargetException, 
	SecurityException, 
	NoSuchFieldException, 
	ClassNotFoundException 
	{
		T bean = beanClazz.newInstance();
		
		List<Method>  setters = getSetters(beanClazz);
		
		for(Method setter : setters)
		{
			Object value = getParameter(beanClazz, setter);
			invokeSetterOnBean(bean, setter, value);
		}
			
		return bean;
	}

	
	private <T> Object getParameter(Class<T> beanClazz, Method setter) throws IllegalArgumentException, 
														InstantiationException, 
														IllegalAccessException, 
														InvocationTargetException, SecurityException, NoSuchFieldException, ClassNotFoundException {
     	
		Class<?> parameterClazz = setter.getParameterTypes()[0];
     	
	      if(parameterClazz.equals(List.class))
	      {	  
	    	  Field field = getFieldFromSetter(beanClazz, setter);
	    	  Object objectForList = getObjectForList(field);
	    	  
              List<Object> parameterObj = new ArrayList<Object>();
              parameterObj.add(objectForList);
              return parameterObj;
	      }
     	
     	return new ValueFactory().getValueFor(parameterClazz);
	}


	private Object getObjectForList(Field field) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException 
	{
  	  Type type = field.getGenericType();  
      System.out.println("type: " + type);  
      if (type instanceof ParameterizedType) {  
          ParameterizedType pt = (ParameterizedType) type;   
          Type t = pt.getActualTypeArguments()[0]; 
           return setValues(Class.forName(t.toString().substring(t.toString().indexOf(' ')+1)));

      }
      
      return null;
	}


	private <T> Field getFieldFromSetter(Class<T> beanClazz, Method setter) throws SecurityException, NoSuchFieldException {
		return  beanClazz.getDeclaredField(setter.getName().substring(3, 4).toLowerCase() + setter.getName().substring(4));
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
    
    private void fillListRecursively(Class<?> clazz, List<Method> allMethods) throws IllegalArgumentException, 
																					    IllegalAccessException, 
																					    InvocationTargetException 
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
