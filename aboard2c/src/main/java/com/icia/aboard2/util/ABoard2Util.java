package com.icia.aboard2.util;

import org.springframework.validation.*;

public class ABoard2Util {
	public static void throwBindException(BindingResult results) throws BindException {
		if(results.getErrorCount()>0)
			throw new BindException(results);
	}
}
