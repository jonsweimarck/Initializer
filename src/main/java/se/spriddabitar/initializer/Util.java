package se.spriddabitar.initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Util{
    static final String GET = "get";
    static final String IS = "is";
    static final String SET = "set";

    /**
     * Gets the setters of a pojo as a map of {@link String} as key and 
     * {@link Method} as value.
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static Map<String,Method> getSetterMethods(Class<?> pojoClass) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
    {
        HashMap<String,Method> methods = new HashMap<String,Method>();
        fillSetterMethods(pojoClass, methods);
        return methods;
    }
    
    private static void fillSetterMethods(Class<?> pojoClass, Map<String,Method> baseMap) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException 
    {
        if(pojoClass.getSuperclass()!=Object.class)
            fillSetterMethods(pojoClass.getSuperclass(), baseMap);
        
        Method[] methods = pojoClass.getDeclaredMethods();
        for(int i=0; i<methods.length; i++)
        {
            Method m = methods[i];
            if(!Modifier.isStatic(m.getModifiers()) && m.getParameterTypes().length==1 && 
                    m.getName().startsWith(SET) && Modifier.isPublic(m.getModifiers()))
            {	
                baseMap.put(toProperty(SET.length(), m.getName()), m);
            }
        }
    }
    
    /**
     * Converts a method name into a camel-case field name, starting from {@code start}.
     */
    public static String toProperty(int start, String methodName)
    {
        char[] prop = new char[methodName.length()-start];
        methodName.getChars(start, methodName.length(), prop, 0);
        int firstLetter = prop[0];
        prop[0] = (char)(firstLetter<91 ? firstLetter + 32 : firstLetter);
        return new String(prop);
    }
}
