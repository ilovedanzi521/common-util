package com.win.dfas.common.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.win.dfas.common.enumeration.IEmunParam;
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
	/**
	 * 对应的枚举类
	 */
	private Class<? extends Enum<?>> enumClass;
	/**
	 * 对应的枚举名称
	 */
	private String enumName;

	@Override
	public void initialize(IsEnumParamValid isEnumParamValid) {
		this.enumClass = isEnumParamValid.enumClass();
		this.enumName = isEnumParamValid.enumName();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Class<?> clazz = IEmunParam.class;
		Object[] oo = enumClass.getEnumConstants();
		try {
			Method method = clazz.getMethod("emunIsValid", this.enumName.getClass(), value.getClass());
			Boolean result = (Boolean) method.invoke(oo[0], this.enumName, value);
			return result == null ? false : result;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return false;
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
	}

}
