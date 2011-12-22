package se.spriddabitar.initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueFactory {

	   private static final int A_NUMBER = 1;
	 
	   private Map<Class<?>, Object> typeValues;
	 
	   public ValueFactory() 
	   {
	      typeValues = new HashMap<Class<?>, Object>();
	      typeValues.put(String.class, String.valueOf(A_NUMBER));
	      typeValues.put(Long.class, new Long(A_NUMBER));
	      typeValues.put(Long.TYPE, new Long(A_NUMBER));
	      typeValues.put(Integer.class, Integer.valueOf(A_NUMBER));
	      typeValues.put(Integer.TYPE, Integer.valueOf(A_NUMBER));
	      typeValues.put(Boolean.class, Boolean.TRUE);
	      typeValues.put(Boolean.TYPE, Boolean.TRUE);
	      typeValues.put(Long[].class, new Long[0]);
	      typeValues.put(Integer[].class, new Integer[0]);
	      typeValues.put(String[].class, new String[0]);
	      typeValues.put(Boolean[].class, new Boolean[0]);
	   }
	 
	   public Object getValueFor(Class<?> clazz) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException, ClassNotFoundException 
	   {
	      if(Modifier.isFinal(clazz.getModifiers())) 
	      {
	         return typeValues.get(clazz);
	      }
//		// TODO  
//	      if(type.equal(XmlGregorianCalendar))
	      

	      
	      
//	      if(clazz.equals(List.class))
//	      {
//	    	  
//	    	  Object list = clazz.newInstance();
//	    	  Method add = List.class.getDeclaredMethod("add",Object.class);
//	    	  add.invoke(list, addToAddToList);
//
//	      }
	      
	      return new Initializer().setValues(clazz);
	      
	      
	   }

}
