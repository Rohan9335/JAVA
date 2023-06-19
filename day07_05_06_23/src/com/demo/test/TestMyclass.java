package com.demo.test;

//import com.demo.beans.Myclass;
//import com.demo.interfaces.Myinter1;
import com.demo.interfaces.*;
import com.demo.beans.*;

public class TestMyclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Myinter1 ob=new Myclass();
		int a=ob.test(2, 2);
		System.out.println(a);
		
		Myinter1 ob2 = (a1,b)->a1+b;
		ob2.test(0, 0);
		
		
		
		MyGeneric <String> first=(x,y)->{
			return x+y;
		};
		
		MyGeneric<Integer>intfirst=(x,y)->{
			return x+y;
		};
		
		Piy <String> row=(w,e)->{
			return w+e;
		};
		String y=row.split("r","t");
		
		System.out.println(" "+y);
		
		
	//	MyGeneric2<Long, Integer> ob3=()->{};
	} 

}
