package com.win.dfas.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 包名称：com.win.dfbp.basicparameter.util
 * 类名称：DateJsonDeserializer
 * 类描述：将'yyyy-MM-dd'T'HH:mm:ss.SSS'Z''的时间字符串转为'yyyy-MM-dd的格式
 * 创建人：@author jianshengxiong
 * 创建时间：2019/6/5/10:15
 *
 */
public class DateJsonDeserializer extends JsonDeserializer<String> {

    private static final Logger logger = LoggerFactory.getLogger(LongJsonDeserializer.class);

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText();
        SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return value == null ? null : format.format(parse.parse(value));
        } catch (ParseException e) {
            logger.error("解析时间类型错误", e);
            return null;
        }
    }
}
