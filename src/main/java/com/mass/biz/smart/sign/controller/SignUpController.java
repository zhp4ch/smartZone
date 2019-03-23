package com.mass.biz.smart.sign.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.sign.model.SignUpModel;
import com.mass.biz.smart.sign.service.SignUpService;
import com.mass.core.framework.aop.LogAop;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;

/**
 * 考勤打卡Controller
 * 
 * @author vm3
 * 
 */
@RestController
@RequestMapping("/signUp")
public class SignUpController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(SignUpController.class);

	@Autowired
	private SignUpService signService;
	
	@Value("${preUrl.pre-path}")
	private String preUrl;
	
	/**
	 * 考勤list查询
	 * 
	 * @param signModel
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list")
	@LogAop(menuName = "考勤打卡", operationDesc = "查询", operationType = "3")
	public AjaxResponse list(SignUpModel signModel,
			@RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		try {
			if (signModel.getTimeBefore() != null
					&& signModel.getTimeAfter() != null) {
				signModel.setTimeBefore(signModel.getTimeBefore().trim());
				signModel.setTimeAfter(signModel.getTimeAfter().trim());
			}
			Long count = signService.count(signModel);
			List<SignUpModel> list = signService.selectPageList(signModel,
					(pageIndex-1)*pageSize, pageSize);
			if(list!=null){
				for(SignUpModel model : list){
					model.setId_image(preUrl + model.getId_image());
				}
			}
			return AjaxResponse.success("ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("select SignModel error!", e);
			return null;
		}
	}

	@RequestMapping(value = "/userDetail")
	@LogAop(menuName = "考勤打卡", operationDesc = "查询", operationType = "3")
	public AjaxResponse getUserDetail(SignUpModel signModel,
			@RequestParam(value = "page") Integer pageIndex,
			@RequestParam(value = "limit") Integer pageSize) {
		try {
			if (signModel.getTimeBefore() != null
					&& signModel.getTimeAfter() != null) {
				signModel.setTimeBefore(signModel.getTimeBefore().trim());
				signModel.setTimeAfter(signModel.getTimeAfter().trim());
			}
			Long count = signService.detailCount(signModel);
			List<SignUpModel> list = signService.getUserDetail(signModel,
					pageIndex - 1, pageSize);
			return AjaxResponse.success("ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getUserDetail error!", e);
			return null;
		}
	}
	
	/**
	 * 按月统计考勤人数
	 * @return
	 */
	@RequestMapping(value = "/selectMonthCount")
	public AjaxResponse selectMonthCount() {
		List<Object> list = signService.selectMonthCount();
		return AjaxResponse.success("ok",list);
	}
	
	/**
	 * 查询本月和上月每天考勤人数
	 * @return
	 */
	@RequestMapping(value = "/selectDayCount")
	public AjaxResponse selectDayCount() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH )+1;
		String date1 = String.valueOf(month).length()==1?year+"-0"+month:year+"-"+month;
		month = month-1;
		String date2 = String.valueOf(month).length()==1?year+"-0"+month:year+"-"+month;
		List<Object> list = new ArrayList<>();
		list.add(signService.selectDayCount(date1));
		list.add(signService.selectDayCount(date2));
		return AjaxResponse.success("ok",list);
	}

	/**
	 * 初始化打卡数据
	 * 定时器
	 * 每天早上6:00执行
	 */
	@Scheduled(cron="0 0 6 ? * *")
	@RequestMapping(value = "/initSignData")
	public void initSignData(){
		signService.initSignData();
	}
	
	/**
	 * 考勤导出
	 * @param signRule
	 * @param response
	 */
	@RequestMapping(value = "/exportForm")
	public void exportForm( SignUpModel signUpModel,HttpServletRequest request, HttpServletResponse response){
		List<SignUpModel> list = this.signService.exportForm(signUpModel);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("考勤记录表");
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "姓名","所属商户","上班打卡时间","上班打卡状态","下班打卡时间","下班打卡状态"};
		int colNum = strArr.length;
		int rowNO = 0;
		if(list!=null&&list.size()>0){
			eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum,list.get(0).getCorporate_name()
					+"考勤记录表"+signUpModel.getUpdate_time());
			rowNO++;
		}else{
			eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum,signUpModel.getCorporate_name()
					+"考勤记录表"+signUpModel.getTimeBefore()+"-"+signUpModel.getTimeAfter());
			rowNO++;
		}	
		
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum,
			"制表时间： "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			SignUpModel sign = list.get(i);
			strings[i][0] = sign.getName();
			strings[i][1] = sign.getCorporate_name();
			strings[i][2] = sign.getOn_time();
			if(sign.getOn_state()==0 || sign.getOn_state()==null){
				strings[i][3] = "未打卡";
			}else if(sign.getOn_state()==1){
				strings[i][3] = "正常";
			}else if(sign.getOn_state()==2){
				strings[i][3] = "迟到";
			}
			strings[i][4] = sign.getOff_time();
			if(sign.getOff_state()==0 || sign.getOff_state()==null){
				strings[i][5] = "未打卡";
			}else if(sign.getOff_state()==1){
				strings[i][5] = "正常";
			}else if(sign.getOff_state()==2){
				strings[i][5] = "早退";
			}
		}
		// sheet (创建sheet) rowNo 报表的单行行号(创建第几行) columnData 报表行中显示的数据
		// maxValue Excel显示的最大上限
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);

		// 创建通用的Excel最后一行的信息 (创建合计行 (最后一行)) workbook 如果为空 则没有样式 colNum
		// 报表的总列数 (合并) fontCaption 报表行中显示的字符
		// fontSize 字体的大小 (字体大小 默认 200) fontWeight 报表表头显示的字符 align 字体水平位置
		// (center中间 right右 left左) colNum 报表的列数 (需要合并到的列索引)
		
		/*eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200,"", "right");*/
		List<SignUpModel> listState=this.signService.countState(signUpModel);
		SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFSheet sheet1 = workbook.createSheet("打卡统计表");
		ExportExcelUtil eeua = new ExportExcelUtil(workbook, sheet1);
		String[] countArr =new String[] {"姓名","所属商户","上班未打卡","迟到","下班未打卡","早退"};
		int colNum1 = countArr.length;
		int rowNO1 = 0;
		eeua.createExcelRow(workbook,sheet1, rowNO1, -1, colNum1,"打卡统计");
		rowNO1++;
		
		eeua.createExcelRow(workbook,sheet1,rowNO1,350,colNum,
		   "制表时间： "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO1++;
		
		eeua.createColumnHeader(sheet1, rowNO1, 300, countArr);
		rowNO1++;
		
		String[][] state = new String[listState.size()][6];
		for(int i = 0; i< listState.size();i++){
			SignUpModel sign = listState.get(i);
			state[i][0] = sign.getName();
			state[i][1] = sign.getCorporate_name();
			state[i][2] = sign.getOnHitCode().toString();
			state[i][3] = sign.getLate().toString();
			state[i][4] = sign.getOffHitCode().toString();
			state[i][5] = sign.getLeava().toString();
		}
		// sheet (创建sheet) rowNo 报表的单行行号(创建第几行) columnData 报表行中显示的数据
				// maxValue Excel显示的最大上限
		sheet1 = eeua.createColumnData(sheet1, rowNO1, state, 65534);
		
		// 导出路径
		String fileName = "考勤记录表.xls";
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
