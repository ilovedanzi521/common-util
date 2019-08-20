/****************************************************
 * 创建人：     @author jianshengxiong  
 * 创建时间: 2019/8/20/16:40
 * 项目名称：dfbp-common-basicparameter
 * 文件名称: FKUtil.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import com.win.dfas.common.enumeration.FKEnum;
/**   
 * 包名称：com.win.dfas.common.util
 * 类名称：FkUtil
 * 类描述：外键工具类
 * 创建人：@author jianshengxiong
 * 创建时间：2019/8/20/16:40
 *     
 */ 
public class FkUtil {

    /**
     * 查看是否存在该外键
     * @param fkEnum 外键类型
     * @param value 外键key
     * @return java.lang.Boolean
     * @throws
     * @author jianshengxiong
     * @date  2019/8/20/16:41
     */
    public static Boolean isExist(FKEnum fkEnum,String value){
        String[] types = fkEnum.getTypes();
        for(String type: types){
            String redisKey = type+"-"+value;
            if(RedisUtil.hasKey(redisKey)){
                return true;
            }
        }
        return false;
    }
}
