package com.mass.biz.smart.user.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.editor.language.json.converter.util.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;
import com.mass.biz.smart.merchantMgt.service.SzMerchantMgtService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.ExcelUtil;
import com.mass.biz.utils.StringUtil;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;

/**
 * 用户信息Controller
 * 
 * @author jiangd
 */
@RestController
@RequestMapping(value = "/szUser")
public class SzUserController {

	@Autowired
	private SzUserService szUserService;
	@Autowired
	SzMerchantMgtService szMerchantMgtService;
	 
	private final static Logger LOGGER = LoggerFactory.getLogger(SzUserController.class);
	private List<SzUser> userList = null;

	/**
	 * 用户信息分页查询
	 * 
	 * @param szUser
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public AjaxResponse list(SzUser szUser, @RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		Long count = szUserService.count(szUser);
		List<SzUser> list = szUserService.selectPageList(szUser, (pageIndex - 1) * pageSize, pageSize);
		userList= list;
		return AjaxResponse.success("ok", list, count, pageIndex);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public AjaxResponse delete(Integer rid, Integer delFlag) {
		try {
			return this.szUserService.delete(rid, delFlag) ? AjaxResponse.success("delUser ok")
					: AjaxResponse.error("delUser error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("delUser error");
			return AjaxResponse.error("delUser error");
		}
	}

	@RequestMapping(value = "/getEntityById", method = RequestMethod.POST)
	public AjaxResponse getEntityById(@RequestParam(value = "rid") Integer rid) {
		try {
			SzUser szUser = this.szUserService.getEntityById(rid);
			return AjaxResponse.success("ok", szUser);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("select SzUser error!", e);
			return AjaxResponse.error("error");
		}
	}

	@RequestMapping(value = "/getEntityByOpenId", method = RequestMethod.POST)
	public AjaxResponse getEntityByOpenId(@RequestParam(value = "openId") String openId) {
		try {
			SzUser szUser = this.szUserService.getEntityByOpendId(openId);
			return AjaxResponse.success("ok", szUser);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("select SzUser error!", e);
			return AjaxResponse.error("error");
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AjaxResponse editEntity(SzUser szUser, HttpSession session) {
		return this.szUserService.update(szUser) ? AjaxResponse.success("update ok")
				: AjaxResponse.error("update error");
	}

	@LogAop(menuName = "Excel信息", operationDesc = "批理插入", operationType = "1")
	@RequestMapping(value = "/batchImport", method = RequestMethod.POST)
	@Transactional
	public AjaxResponse batchInsert(@RequestParam("file") MultipartFile file, HttpSession session) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list = ExcelUtil.readXls(file);

			List<SzUser> userList = new ArrayList<SzUser>();

			for (Map<String, Object> m : list) {

				SzUser szUser = new SzUser();
				String merchant_name = "";

				for (String k : m.keySet()) {

					switch (k) {
						case "姓名":
							szUser.setName(m.get(k).toString());
							break;
						case "身份证号":
							szUser.setId_code(m.get(k).toString());
							break;
						case "联系电话":
							szUser.setPhone(m.get(k).toString());
							break;
/*						case "公司编码":
							szUser.setMerchant_code(m.get(k).toString());
							break;*/
						case "公司名称":
							merchant_name = m.get(k).toString();
							break;
					}

				}
				
				//1.非空
				if(StringUtil.isEmpty(szUser.getName()) || 
						StringUtil.isEmpty(szUser.getId_code()) ||
						StringUtil.isEmpty(szUser.getPhone()) ||
						StringUtil.isEmpty(merchant_name) ){
					continue;	
				}
				
				//2.merchant_code有效
				SzMerchantMgt szMerchantMgt = new SzMerchantMgt();
				szMerchantMgt.setCorporateName(merchant_name);
				String merchant_code = szMerchantMgtService.selectMerchantcodeByName(szMerchantMgt);
				if (StringUtil.isEmpty(merchant_code)) {
					continue;
				}
				
				//3.身份证号有效
				Long count_ic = szUserService.countByIdCode(szUser);
				if (count_ic != null && count_ic > 0) {
					continue;
				} 
				
				//4.setMerchant_code
				szUser.setMerchant_code(merchant_code);
				userList.add(szUser);
				
			}
			
			int count = 0;
			
			if(userList!=null && userList.size()>0)
			 count = szUserService.batchInsert(userList);
			
			return count > 0 ? AjaxResponse.success("ok", count) : new AjaxResponse("BatchImport", "error", "id");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("BatchImport SzUser error!", e);
			return AjaxResponse.error("error");
		}
	}

	@LogAop(menuName = "身份证照片", operationDesc = "批理插入", operationType = "1")
	@RequestMapping(value = "/idcard/import", method = RequestMethod.GET)
	@Transactional
	public AjaxResponse idCardImport(@RequestParam("jsonStr") String jsonStr, HttpSession session) {
		List<SzUser> list = JSONObject.parseArray(jsonStr, SzUser.class);
		if (CollectionUtils.isNotEmpty(list)) {
			szUserService.updateBatch(list);
		}
		return AjaxResponse.success("import success");
	}

/*	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	@Transactional
	public void userListInfoImport(SzUser szUser,HttpServletResponse response) {
		List<SzUser> list = this.szUserService.selectListByCondition(szUser);
		String[] listName = new String[]{"名字","身份证","昵称","联系电话","公司名称","注册时间"};
		String[] listId = new String[]{"name","id_code","nickname","phone","corporateName","create_time"};
		ExportBeanExcel<SzUser> exportBeanExcelUtil = new ExportBeanExcel();
	    exportBeanExcelUtil.exportExcel(response,"用户列表","用户列表",Arrays.asList(listName),Arrays.asList(listId),CollectionUtils.isEmpty(userList)?list:userList);
	}*/
	
	/**
	 * 用户导出
	 * @param signRule
	 * @param response
	 */
	@RequestMapping(value = "/exportExcel")
	public void exportForm( SzUser szUser,HttpServletRequest request, HttpServletResponse response){
		List<SzUser> list = this.szUserService.selectListByCondition(szUser);
		list =CollectionUtils.isEmpty(userList)?list:userList;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("用户列表");
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "姓名","身份证","昵称","联系电话","公司名称","注册时间"};
		int colNum = strArr.length;
		int rowNO = 0;
		if(list!=null&&list.size()>0){
			eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum,"用户列表");
			rowNO++;
		}else{
			eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum,"考勤记录表");
			rowNO++;
		}	
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum,
			"制表时间： "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			SzUser user = list.get(i);
			strings[i][0] = user.getName();
			strings[i][1] = user.getId_code();
			strings[i][2] = user.getNickname();
			strings[i][3] = user.getPhone();
			strings[i][4] = user.getCorporateName();
			strings[i][5] = user.getCreate_time();
		}
		// sheet (创建sheet) rowNo 报表的单行行号(创建第几行) columnData 报表行中显示的数据
		// maxValue Excel显示的最大上限
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);

		// 创建通用的Excel最后一行的信息 (创建合计行 (最后一行)) workbook 如果为空 则没有样式 colNum
		// 报表的总列数 (合并) fontCaption 报表行中显示的字符
		// fontSize 字体的大小 (字体大小 默认 200) fontWeight 报表表头显示的字符 align 字体水平位置
		// (center中间 right右 left左) colNum 报表的列数 (需要合并到的列索引)
		
		eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200,"", "right");
		// 导出路径
		String fileName = "用户信息表.xls";
		//下载
		this.downExcel(fileName, workbook, response);
	}
	/**
	 * 
	* @Title: downExcel 
	* @Description: 下载到浏览器 
	* @param @param fileName
	* @param @param wb
	* @param @param response    入参
	* @return void    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月20日 下午2:34:16 
	* @version V1.0
	 */
	private void downExcel(String fileName, Workbook wb,HttpServletResponse response) {
		OutputStream out = null;
		try {
			String headStr = new StringBuilder().append("attachment;fileName=")
					.append(URLEncoder.encode(fileName, "UTF-8")).toString();
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", headStr);
			out = response.getOutputStream();
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
