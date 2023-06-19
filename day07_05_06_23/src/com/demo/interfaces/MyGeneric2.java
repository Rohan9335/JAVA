package com.demo.interfaces;

public interface MyGeneric2 <T extends Number , F> {
	
	F compare(T x, T y);
}
