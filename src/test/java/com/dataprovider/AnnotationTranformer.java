package com.dataprovider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.IMethodInstance;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTranformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		

		
		Map<String,String> test1map = new HashMap<>();
		test1map.put("name", "test1");
		test1map.put("priority", "1");
		test1map.put("count", "5");
		
		Map<String,String> test2map = new HashMap<>();
		test2map.put("name", "test3");
		test2map.put("priority", "1");
		test2map.put("count", "5");
		
		List<Map<String,String>> list = new ArrayList<>();
		list.add(test1map);
		list.add(test2map);
		for(int i=0;i<list.size();i++) {
			if(testMethod.getName().equalsIgnoreCase(list.get(i).get("name"))) {
				annotation.setPriority(Integer.parseInt(list.get(i).get("priority")));
				annotation.setInvocationCount(Integer.parseInt(list.get(i).get("count")));
				
				
			}
		}
		
		
	}

}
