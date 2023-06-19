package com.demo.test;

import com.demo.beans.Myclass;
import com.demo.interfaces.*;
public class TestMyclass{

	public static void main(String[] args) {
//		
//		I1 ob=new MyClass();
//		ob.m11();
//		((MyClass)ob).m21();
//		I1.methiodstatic();
//		System.out.println(I1.i);
//		//I1.i=45;  //error
		I1 ref=new Myclass();
//		System.out.println(ref);
		ref.m1();
		I1.m2();
		
	}

}
