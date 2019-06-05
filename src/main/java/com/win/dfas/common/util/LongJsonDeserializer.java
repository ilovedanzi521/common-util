/****************************************************
 * 创建人：     @author jianshengxiong  
 * 创建时间: 2019/6/5/10:15
 * 项目名称：dfbp-common-basicparameter
 * 文件名称: LongJsonDeserializer.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 包名称：com.win.dfbp.basicparameter.util
 * 类名称：LongJsonDeserializer
 * 类描述：将字符串转反序列化为Long
 * 创建人：@author jianshengxiong
 * 创建时间：2019/6/5/10:15
 *     
 */ 
public class LongJsonDeserializer extends JsonDeserializer<Long> {

    private static final Logger logger = LoggerFactory.getLogger(LongJsonDeserializer.class);

    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText();
        try {
            return value == null ? null : Long.parseLong(value);
        } catch (NumberFormatException e) {
            logger.error("解析长整形错误", e);
            return null;
        }
    }
}
