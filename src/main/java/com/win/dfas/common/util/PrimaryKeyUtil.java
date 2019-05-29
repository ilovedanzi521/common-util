/**
<<<<<<< HEAD
 * 创建人：     @author hanshenglin
=======
 * 创建人：     @author hanshenglin    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间: 2018年7月30日/下午2:01:56
 * 项目名称：  ycmp-api
 * 文件名称: IdGenerateUtil.java
 * 文件描述: @Description: 分布式主键生成工具类
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2018
<<<<<<< HEAD
 *
 */
package com.win.dfas.common.util;
=======
 * 
 */
package com.dfas.common.util;
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


<<<<<<< HEAD
/**
 * 包名称： com.dfas.common.util
 * 类名称：IdGenerateUtil
 * 类描述：分布式主键生成工具类
 * 创建人：@author hanshenglin
 * 创建时间：2018年7月30日/下午2:01:56
 *
=======
/**   
 * 包名称： com.yhfin.ycmp.api.util 
 * 类名称：IdGenerateUtil 
 * 类描述：分布式主键生成工具类
 * 创建人：@author hanshenglin 
 * 创建时间：2018年7月30日/下午2:01:56
 *     
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 */

public class PrimaryKeyUtil {
    /**
     * logger
     */
    private static  final Logger logger = LoggerFactory.getLogger(PrimaryKeyUtil.class);

    /**
     * 生成分布式主键id
     * @Title: generateId
<<<<<<< HEAD
     * @Description:
     * @return: Long  id Long类型的值 最大为20位   authcenter的id生成接口为不可用时，id可能存在为null的情况
     * @throws
     * @author: hanshenglin
=======
     * @Description: 
     * @return: Long  id Long类型的值 最大为20位   authcenter的id生成接口为不可用时，id可能存在为null的情况
     * @throws
     * @author: hanshenglin 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
     * @Date:  2018年7月30日/下午2:09:22
     */
    public static Long generateId() {
        Long id = null;

        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        id = snowflake.nextId();
        return id;
    }

}
