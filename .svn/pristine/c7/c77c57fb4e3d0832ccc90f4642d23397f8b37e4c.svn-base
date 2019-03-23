package com.mass.biz.smart.property.suggestion.controller; 

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.merchant.service.SzMerchantService;
import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;
import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;
import com.mass.biz.smart.property.suggestion.model.Suggest;
import com.mass.biz.smart.property.suggestion.service.SuggestService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.core.sys.user.model.SysUser;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;
/**
 *
 * 项目名称：smartZone-ht
 * 类名称：SuggestController
 * 类描述：投诉建议控制层
 * 创建人：yihai Zhao
 * 创建时间：2018年7月18日 下午2:44:43
 * 修改人：yihai Zhao
 * 修改时间：2018年7月18日 下午2:44:43
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/suggest")
public class SuggestController {

	private final static Logger LOGGER = LoggerFactory.getLogger(SuggestController.class);
	
	@Autowired
	private SuggestService suggestService;
	
	@Autowired
	private SzUserService szUserService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired 
	private SzMerchantScoreService merchantScoreService;
	
	@Autowired
	private SzMerchantService szMerchantService;
	/**
	* 
	* @Title: addSuggest 
	* @Description: 新增  微信端
	* @param @param suggest
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午2:48:21 
	* @version V1.0
	 */
	@RequestMapping("/addSuggest")
	public AjaxResponse addSuggest(Suggest suggest){
		try {
			SzUser szUser = this.szUserService.getEntityById(suggest.getRid());
			suggest.setName(szUser.getName());
			suggest.setMobilePhone(szUser.getPhone());
			SzMerchant szMerchant = this.szMerchantService.getEntityByUserid(szUser.getRid());
			suggest.setBuilding(szMerchant.getPark()+szMerchant.getBuilding_number()+szMerchant.getDoorNumber());
			Suggest addSuggest = this.suggestService.addSuggest(suggest);
			return AjaxResponse.success("addSuggest ok", addSuggest);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("addSuggest error");
			return AjaxResponse.error("addSuggest error");
		}
	}
	/**
	 * 
	* @Title: editSuggest 
	* @Description: 修改 微信端
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午2:51:15 
	* @version V1.0
	 */
	@RequestMapping("/editSuggest")
	@Transactional
	public AjaxResponse editSuggest(Suggest suggest){
		try {
			//如果审核通过，采纳的话，给予积分奖励
			if(suggest.getState()!=null){
				if(suggest.getState()==2){
					Suggest su = this.suggestService.getSuggestById(suggest.getId());
					merchantScoreService.outsideInsert(su.getRid(),SzMerchantScore.SUGGESTION_TYPE);
					//获取用户的openid发送消息
					SzUser szUser =szUserService.getEntityById(su.getRid());
					szUserService.sendWXMessage(szUser.getOpen_id(), "您的建议已经在"+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"日被采纳，奖励积分"+SzMerchantScore.SUGGESTION_TYPE+"分，感谢您的参与，谢谢");
				}
			}
			return this.suggestService.editSuggest(suggest)?AjaxResponse.success("editSuggest ok"):AjaxResponse.error("editSuggest error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("editSuggest error");
			return AjaxResponse.error("editSuggest error");
		}
	}
	/**
	 * 
	* @Title: delSuggest 
	* @Description: 删除-微信端
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午2:53:04 
	* @version V1.0
	 */
	@RequestMapping("/delSuggest")
	public AjaxResponse delSuggest(@RequestParam("id")Long id){
		try {
			return this.suggestService.delSuggest(id)?AjaxResponse.success("delSuggest ok"):AjaxResponse.error("delSuggest error");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("delSuggest error");
			return AjaxResponse.error("delSuggest error");
		}
	}
	/**
	 * 
	* @Title: getSuggestById 
	* @Description: 详情--后台
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午2:54:42 
	* @version V1.0
	 */
	@RequestMapping("/getSuggestById")
	public AjaxResponse getSuggestById(@RequestParam("id")Long id){
		try {
			Suggest suggest = this.suggestService.getSuggestById(id);
			return AjaxResponse.success("getSuggestById ok",suggest);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getSuggestById error");
			return AjaxResponse.error("getSuggestById error");
		}
	}
	/**
	 * 
	* @Title: selectPageList 
	* @Description: 分页查询 -后台  -不确定是否新框架里封装的layUI里是否还需要返回table。
	* @param @param suggest
	* @param @param pageIndex
	* @param @param pageSize
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午3:14:52 
	* @version V1.0
	 */
	@RequestMapping("/selectPageList")
	public AjaxResponse selectPageList(Suggest suggest,HttpServletRequest request, HttpServletResponse response,
						@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<Suggest> list = this.suggestService.selectPageList(suggest, pageIndex-1, pageSize);
			Long count = this.suggestService.count();
			//SelectOrExport 1-查询  2是导出
			return AjaxResponse.success("selectPageList ok", list,count,pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectPageList error");
			return AjaxResponse.error("selectPageList error");
		}
	}
	/**
	 * 
	* @Title: selectSuggest 
	* @Description: 前台list查询
	* @param @param suggest
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月18日 下午3:59:34 
	* @version V1.0
	 */
	@RequestMapping("/selectSuggest")
	public AjaxResponse selectSuggest(){
		try {
			List<Suggest> list = this.suggestService.selectSuggest();
			return AjaxResponse.success("selectSuggest ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectSuggest error");
			return AjaxResponse.error("selectSuggest error");
		}
	}
	/**
	 * 
	* @Title: selectCountByYear 
	* @Description: 按年统计每个月投诉建议的条数 -柱状图
	* @param @param year
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月19日 上午9:04:39 
	* @version V1.0
	 */
	@RequestMapping("/selectCountByYear")
	public AjaxResponse selectCountByYear(@RequestParam("year")String year){
		try {
			List<Suggest> list = this.suggestService.selectCountByYear(year);
			//因mySql不像oracle一样可以在数据库里做数据补全操作，故在java里做数据处理。
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("01", 0);
			map.put("02", 0);
			map.put("03", 0);
			map.put("04", 0);
			map.put("05", 0);
			map.put("06", 0);
			map.put("07", 0);
			map.put("08", 0);
			map.put("09", 0);
			map.put("10", 0);
			map.put("11", 0);
			map.put("12", 0);
			//查到有数据，做数据更新操作
			for (int i = 0; i < list.size(); i++) {
				Suggest suggest = list.get(i);
				if ("01".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("01", suggest.getCount());
				}else if ("02".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("02", suggest.getCount());
				}else if ("03".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("03", suggest.getCount());
				}else if ("04".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("04", suggest.getCount());
				}else if ("05".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("05", suggest.getCount());
				}else if ("06".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("06", suggest.getCount());
				}else if ("07".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("07", suggest.getCount());
				}else if ("08".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("08", suggest.getCount());
				}else if ("09".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("09", suggest.getCount());
				}else if ("10".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("10", suggest.getCount());
				}else if ("11".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("11", suggest.getCount());
				}else if ("12".equals(suggest.getMonth()) && suggest.getCount()!=0) {
					map.put("12", suggest.getCount());
				}
			}
			return AjaxResponse.success("selectCountByYear", map);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectCountByYear error");
			return AjaxResponse.error("selectCountByYear error");
		}
	}
	/**
	 * 
	* @Title: selectContBySuggestCategory 
	* @Description: 分类统计-饼状图
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月19日 下午5:23:32 
	* @version V1.0
	 */
	@RequestMapping("/selectContBySuggestCategory")
	public AjaxResponse selectContBySuggestCategory(@RequestParam("year") String year){
		try {
			List<Suggest> list = this.suggestService.selectContBySuggestCategory(year);
			return AjaxResponse.success("selectContBySuggestCategory ok ", list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectContBySuggestCategory error");
			return AjaxResponse.error("selectContBySuggestCategory error");
		}
	}
	/**
	* @Title: selectHistory 
	* @Description: 查询个人历史投诉建议
	* @param @param rid
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月7日 下午2:21:11 
	* @version V1.0
	 */
	@RequestMapping("/selectHistory")
	public AjaxResponse selectHistory(@RequestParam("rid")Long rid){
		try {
			List<Suggest> list = this.suggestService.selectHistory(rid);
			return AjaxResponse.success("selectHistory ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectHistory error");
			return AjaxResponse.error("selectHistory error");
		}
	}
	/**
	* @Title: exportSuggest 
	* @Description: 导出
	* @param @param suggest
	* @param @param request
	* @param @param response
	* @param @param pageIndex
	* @param @param pageSize    入参
	* @return void    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月7日 下午2:35:24 
	* @version V1.0
	 */
	@RequestMapping("/exportSuggest")
	public void exportSuggest(Suggest suggest,HttpServletRequest request, HttpServletResponse response,Integer pageIndex,Integer pageSize){
		List<Suggest> list = this.suggestService.selectPageList(suggest, 0, 99999999);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "姓名","楼座号", "联系方式", "投诉日期", "投诉部门","投诉内容",
				"投诉类别","处理人","是否显示","状态","办结日期"};
		int colNum = strArr.length;
		int rowNO = 0;
		eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum, "投诉建议基本信息表");
		rowNO++;
		
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum," "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[list.size()][11];
		for (int i = 0; i < list.size(); i++) {
			Suggest sug = list.get(i);
			strings[i][0] = sug.getName();
			strings[i][1] = sug.getBuilding();
			strings[i][2] = sug.getMobilePhone();
			strings[i][3] = sug.getSuggestTime();					
			strings[i][4] = sug.getSuggestDepartment();	
			strings[i][5] = sug.getSuggestContent();
			if(sug.getSuggestCategory().toString()=="0"){
				strings[i][6] = "";
			}else if(sug.getSuggestCategory().toString()=="1"){
				strings[i][6] = "";
			}else if(sug.getSuggestCategory().toString()=="2"){
				strings[i][6] = "";
			}else if(sug.getSuggestCategory().toString()=="3"){
				strings[i][6] = "";
			}else if(sug.getSuggestCategory().toString()=="4"){
				strings[i][6] = "";
			}
			strings[i][7] = sug.getHandler();
			if (sug.getShowOrHidden().toString()=="0") {
				strings[i][8] = "显示";
			}else if (sug.getShowOrHidden().toString()=="1") {
				strings[i][8] = "隐藏";
			}
			if (sug.getState().toString()=="0") {
				strings[i][9] = "审核中";
			}else if(sug.getState().toString()=="1"){
				strings[i][9] = "已驳回";
			}else if(sug.getState().toString()=="2"){
				strings[i][9] = "已通过";
			}else if(sug.getState().toString()=="3"){
				strings[i][9] = "处理中";
			}else if(sug.getState().toString()=="4"){
				strings[i][9] = "已办结";
			}
			strings[i][10] = sdf.format(sug.getEndDate());
		}
		// sheet (创建sheet) rowNo 报表的单行行号(创建第几行) columnData 报表行中显示的数据
		// maxValue Excel显示的最大上限
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);

		// 创建通用的Excel最后一行的信息 (创建合计行 (最后一行)) workbook 如果为空 则没有样式 colNum
		// 报表的总列数 (合并) fontCaption 报表行中显示的字符
		// fontSize 字体的大小 (字体大小 默认 200) fontWeight 报表表头显示的字符 align 字体水平位置
		// (center中间 right右 left左) colNum 报表的列数 (需要合并到的列索引)
		eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200, "投诉建议基本信息表", "right");
		// 导出路径
		String fileName = "投诉建议基本信息表.xls";
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
	
	/**
	* @Title: selectUserList 
	* @Description: 分页查询所有工作人员 
	* @param @param suggest
	* @param @param pageIndex
	* @param @param pageSize
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 19:28:15
	 */
	@RequestMapping("/selectUserList")
	public AjaxResponse selectUserList(Suggest suggest,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<Suggest> list = this.suggestService.selectUserList(suggest, pageIndex-1, pageSize);
			Long count = this.suggestService.userCount(suggest);
			return AjaxResponse.success("selectUserList ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectUserList error");
		}
	}
	
	/**
	* @Title: addMendUser 
	* @Description: 新增派工人员
	* @param @param suggest
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 19:28:18
	 */
	@RequestMapping("/addMendUser")
	public void addMendUser(Suggest suggest){
		try {
			this.suggestService.addMendUser(suggest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title: addMessage 
	* @Description: 新增消息推送
	* @param @param suggest
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 20:17:42
	 */
	@RequestMapping("/addMessage")
	public AjaxResponse addMessage(Suggest suggest,HttpSession session){
		try {
			SysUser sysUser = (SysUser) session.getAttribute("sysUser");
			Message mes		=	new Message();
			mes.setMsgContent(suggest.getMsg());			//消息内容
			mes.setSendId(sysUser.getId());					//发送人id
			mes.setSendName(sysUser.getName());				//发送人名称
			mes.setUserId(suggest.getRid());				//接收人id
			mes.setMsgState(5);								//消息类型1-推送商户信息类  2-合同到期提醒 3-新闻推送 4-物业费催收 5- 管理员推送给监管人员
			mes.setStatus(3); 								//发送人身份识别 1-个人 2-商户 3-管理员
			mes.setReadFlag(0);								//阅读标记 -->0-未读 1-已读
			mes.setManyId(suggest.getId()); 				//外键id
			messageService.addMessage(mes);
			return AjaxResponse.success("ok","");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResponse("fail","","");
		}
	}
}
