/****************************************************
 * 创建人：     @author jianshengxiong  
 * 创建时间: 2019/6/5/10:13
 * 项目名称：dfbp-common-basicparameter
 * 文件名称: LongJsonSerializer.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 包名称：com.win.dfbp.basicparameter.util
 * 类名称：LongJsonSerializer
 * 类描述：Long字段序列化时转为字符串
 * 创建人：@author jianshengxiong
 * 创建时间：2019/6/5/10:13
 *
 */
public class LongJsonSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String text = (value == null ? null : String.valueOf(value));
        if (text != null) {
            gen.writeString(text);
        }
    }
}
