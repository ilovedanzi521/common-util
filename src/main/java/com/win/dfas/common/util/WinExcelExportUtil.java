/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月25日/上午9:31:37
 * 项目名称：  dfas-common-util
 * 文件名称: WinExcelExportUtil.java
 * 文件描述: @Description: Excel导出工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import java.util.List;

import org.springframework.ui.ModelMap;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.hutool.core.collection.CollectionUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinExcelExportUtil 
 * 类描述：Excel导出工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月25日/上午9:31:37
 *     
 */
public final class WinExcelExportUtil {

	/**
	 * 
	 * Excel导出
	 * @Title: exportExcel
	 * @param map
	 * @param list
	 * @param exportParams   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月25日/下午7:02:48
	 */
	public static void exportExcel(List<?> list, ExportParams exportParams) {
		
		if (CollectionUtil.isEmpty(list)) {
			return;
		}
		
		ModelMap map = new ModelMap();
		
		map.put(NormalExcelConstants.DATA_LIST, list);
		map.put(NormalExcelConstants.CLASS, list.get(0).getClass());
		map.put(NormalExcelConstants.PARAMS, exportParams);
		
		PoiBaseView.render(map, RequestUtil.getRequest(), ResponseUtil.getResponse(), NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}
	
}
