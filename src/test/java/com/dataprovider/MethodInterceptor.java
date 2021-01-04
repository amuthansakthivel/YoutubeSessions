package com.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;



public class MethodInterceptor implements IMethodInterceptor{

	

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		System.out.println("abcd");
		
		methods.forEach(e->System.out.println(e.getMethod().getMethodName()));
		
		List<IMethodInstance> result = new ArrayList<>();
		
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

		for(int i=0 ; i< methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))){
					methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}

}
