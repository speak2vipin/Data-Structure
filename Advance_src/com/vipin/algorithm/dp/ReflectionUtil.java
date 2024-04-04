package com.vipin.algorithm.dp;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {
    public static void main(String[] args) {
        // At runtime, you determine the structure of MyObject
        Map<String, Object> attributeValues = new HashMap<>();
        attributeValues.put("name", "John");
        attributeValues.put("age", 25);

        MyObject myObject = createObjectDynamically(MyObject.class, attributeValues);

        System.out.println(myObject);
    }

    public String getName() {
        try {
            Field nameField = getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            return (String) nameField.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static <T> T createObjectDynamically(Class<T> clazz, Map<String, Object> attributeValues) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : attributeValues.entrySet()) {
                String attributeName = entry.getKey();
                Object attributeValue = entry.getValue();

                Field field = clazz.getDeclaredField(attributeName);
                field.setAccessible(true);

                // Note: You might need to handle type conversions appropriately here
                field.set(instance, attributeValue);
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately in your application
            return null;
        }
    }
}

class MyObject {
	
}