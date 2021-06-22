package vabiss.com.userRegister.core.business;

/*bu klas resultları yoxlayır və error olarsa dayanır və çıxışa  resultu göndərir */

import org.springframework.stereotype.Component;

import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.core.utils.results.SuccessResult;

@Component
public class BusinessEngine {
	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
