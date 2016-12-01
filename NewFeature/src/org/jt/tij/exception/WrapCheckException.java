package org.jt.tij.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WrapCheckException {
	public void throwRuntimeException(int type) {
        try {
        	switch (type) {
        	case 0: throw new FileNotFoundException();
        	case 1: throw new IOException();
        	case 2: throw new RuntimeException();
        	default: return;
        	}
        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
	}
	public static void main(String arg[]) {
		
	}

}
