package com.win.dfas.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.hutool.core.util.ObjectUtil;
import com.win.dfas.common.enumeration.FormatEnum;
import com.win.dfas.common.util.RedisUtil;

/**
 * 
 * 包名称： com.win.dfas.common.validation 
 * 类名称：IsAParamValidValidator 
 * 类描述：对缓存redis中数据校验
 * 创建人：@author tandun 
 * 创建时间：2019年8月13日/下午5:24:07
 *
 */
public class IsAParamValidValidator implements ConstraintValidator<IsAParamValid, Object>{
    /**
     * 对应的枚举
     */
	private FormatEnum enumValue;
	/**
	 * 对应redis缓存中的关键字中其中一部分
	 */
	private String prefixParam;
    @Override
    public void initialize(IsAParamValid isAParamValid) {
    	this.enumValue = isAParamValid.enumValue();
    	this.prefixParam = isAParamValid.prefixParam();
    }
 
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
		FormatEnum formatEnum = this.enumValue;
		String formatKey = formatEnum.getFormat();
		String strDictKey = String.format(formatKey, this.prefixParam, obj);
		//如获取值为空,不做校验
		if(ObjectUtil.isEmpty(obj)) {
			return true;
		}
		// 判断缓存里面是否存在此关键字
		if (RedisUtil.hasKey(strDictKey)) {
			// 获取redis缓存的值
			Object dictObj = RedisUtil.get(strDictKey);
			if (dictObj != null) {
				return true;
			}
		}
		return false;
	}
	 

}
