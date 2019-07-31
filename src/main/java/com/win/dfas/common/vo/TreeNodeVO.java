/**   
 * 包名称：com.win.dfas.common.vo
 * 类名称：TreeNodeVO
 * 类描述：
 * 创建人：@author jianshengxiong
 * 创建时间：2019/7/30/9:49
 *     
 */ 
package com.win.dfas.common.vo;

import lombok.Data;

import java.util.List;
/****************************************************
 * 创建人：     @author jianshengxiong  
 * 创建时间: 2019/7/30/9:49
 * 项目名称：dfbp-common-basicparameter
 * 文件名称: TreeNodeVO.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

@Data
public class TreeNodeVO {

    private String value;

    private String label;

    private List<TreeNodeVO> children;
}
