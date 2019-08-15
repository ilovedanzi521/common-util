package com.win.dfas.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.win.dfas.common.enumeration.EmunParam;
/**
 * 
 * 包名称： com.win.dfas.common.validation 
 * 类名称：IsEnumParamValidator 
 * 类描述：枚举类数据校验
 * 创建人：@author tandun 
 * 创建时间：2019年8月14日/上午11:19:38
 *
 */
public class IsEnumParamValidator implements ConstraintValidator<IsEnumParamValid, Object> {
	
	private EmunParam emunType;
	@Override
	public void initialize(IsEnumParamValid isEnumParamValid) {
       this.emunType = isEnumParamValid.emunType();
	}

	@Override
	public boolean isValid(Object arg, ConstraintValidatorContext context) {
		  //对比枚举类中是否存在该枚举值
		  for(EmunParam emun:EmunParam.values()) {
			  if(emun.compareTo(this.emunType) > 0 && emun.getEmunValue().equals(arg)) {
				  return true;
			  }
		  }
		return false;
	}

}
