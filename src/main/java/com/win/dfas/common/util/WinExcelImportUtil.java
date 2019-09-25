/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月25日/上午9:36:48
 * 项目名称：  dfas-common-util
 * 文件名称: WinExcelImportUtil.java
 * 文件描述: @Description: Excel导入工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinExcelImportUtil 
 * 类描述：Excel导入工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月25日/上午9:36:48
 *     
 */
public class WinExcelImportUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WinExcelImportUtil.class);

	/**
	 * @Title: importExcel
	 * @Description: 上传excel.xlsx(这里会去除表格的第一行标题，第二行表)
	 * @param request
	 * @param response
	 * @param file
	 * @param pojoClass
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException   
	 * @return: List   
	 * @throws
	 * @author: huhe 
	 * @Date:  2019年9月24日/下午8:34:50
	 */
	@SuppressWarnings("rawtypes")
	public static List importExcel(HttpServletRequest request,HttpServletResponse response,MultipartFile file,Class<?> pojoClass ) throws IllegalStateException, IOException {
		try {
			if (!file.isEmpty()) {
				String orgName = file.getOriginalFilename();
				String extName = orgName.substring(orgName.lastIndexOf("."));
				String extensionPermit = ".xlsx";
				if (!extensionPermit.equals(extName)) {
					throw new RuntimeException("文件类型不对");
				}
				String newFileName = UUID.randomUUID().toString() + extName;
				// 文件保存路径
				String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
				File filepath = new File(path, newFileName);
				// 判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) {
					filepath.getParentFile().mkdirs();
				}
				String filePath2 = path + File.separator + newFileName;
				//保存文件
				file.transferTo(new File(filePath2));
				ImportParams params = new ImportParams();
		        params.setTitleRows(1);
		        params.setHeadRows(1);
				List list = ExcelImportUtil.importExcel(new File(filePath2),pojoClass, params);
				LOGGER.info("list is {}", list);
		        return list;
			}
		} catch (Exception e) {
			throw new RuntimeException("上传读取文件失败");
		}
		return null;
	}
}
