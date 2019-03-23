package com.mass.biz.smart.property.propertyPriceStatistics.controller; 

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.merchant.service.SzMerchantService;
import com.mass.biz.smart.property.propertyPriceStatistics.model.PropertyPrice;
import com.mass.biz.smart.property.propertyPriceStatistics.service.PropertyPriceService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.ExcelUtil;
import com.mass.biz.utils.StringUtil;
import com.mass.core.sys.file.service.FileUploadService;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：PropertyPriceController
 * 类描述：物业统计控制层
 * 创建人：zx
 * 创建时间：2018‎年‎8‎月‎8‎日 10:14:05
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/propertyPrice")
public class PropertyPriceController {

	 private static long orderNum = 0l;  
	 
	 private static String date ;  
	
	@Autowired
	private PropertyPriceService propertyPriceService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private SzMerchantService szMerchantService;
	
	@Autowired
	private SzUserService szUserService;
 	
	/**
	* @Title: addPropertyPrice 
	* @Description: 物业统计新增 
	* @param @param propertyPrice
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:16:09
	 */
	@RequestMapping("/addPropertyPrice")
	@Transactional
	public AjaxResponse addPropertyPrice(PropertyPrice propertyPrice)throws InterruptedException{
		try {
			//String orderNo = PropertyPriceController.getOrderNo();
			//propertyPrice.setReceiptNumber(orderNo);
			PropertyPrice pp= this.propertyPriceService.addPropertyPrice(propertyPrice);
			SzUser entityById = this.szUserService.getEntityById(propertyPrice.getUserId());
			this.szUserService.sendWXMessage(entityById.getOpen_id(), "您有一笔新费用待支付，明细如下："+"\n"+"物业费用:"+propertyPrice.getPropertyCharge()
					+"元"+"\n"+"水电费用："+propertyPrice.getHydropowerCharge()+"元"+"\n"+"合计："+propertyPrice.getTotal()+"元"+"\n"
					+"应缴时间:"+propertyPrice.getShouldPayDate()+"\n"+"温馨提示："+"\n"+"您可进入智慧园区公众号查看费用详情，支付费用哦，也可直接到物业线下支付！");
			return AjaxResponse.success("ok",pp);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error",propertyPrice);
		}
	}
	/**
	* @Title: editPropertyPrice 
	* @Description: 物业统计修改
	* @param @param propertyPrice
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:20:23
	 */
	@RequestMapping("/editPropertyPrice")
	public AjaxResponse editPropertyPrice(PropertyPrice propertyPrice){
		try {
			return this.propertyPriceService.editPropertyPrice(propertyPrice)?AjaxResponse.success("ok", propertyPrice):AjaxResponse.error("error", propertyPrice);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error", propertyPrice);
		}
	}
	/**
	* @Title: delPropertyPrice 
	* @Description: 物业统计逻辑删除
	* @param @param id
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:25:11
	 */
	@RequestMapping("/delPropertyPrice")
	public AjaxResponse delPropertyPrice(@RequestParam("id")Long id){
		try {
			return this.propertyPriceService.delPropertyPrice(id)?AjaxResponse.success("ok", id):AjaxResponse.error("error", id);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	/**
	* @Title: getPropertyPriceById 
	* @Description: 物业统计详情
	* @param @param id
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:30:34
	 */
	@RequestMapping("/getPropertyPriceById")
	public AjaxResponse getPropertyPriceById(@RequestParam("id")Long id){
		try {
			PropertyPrice pp = this.propertyPriceService.getPropertyPriceById(id);
			return AjaxResponse.success("ok ", pp);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	/**
	* @Title: selectPageList 
	* @Description: 分页查询 
	* @param @param propertyPrice
	* @param @param pageIndex
	* @param @param pageSize
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:36:21
	 */
	@RequestMapping("/selectPageList")
	public AjaxResponse selectPageList(PropertyPrice propertyPrice,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<PropertyPrice> list = this.propertyPriceService.selectPageList(propertyPrice, pageIndex-1, pageSize);
			Long count = this.propertyPriceService.count(propertyPrice);
			return AjaxResponse.success("ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	* @Title: queryUserByCreatTime 
	* @Description: 查询当月未创建账单人员信息
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:45:08
	 */
	@RequestMapping("/queryUserByCreatTime")
	public AjaxResponse queryUserByCreatTime(){
		try {
			List<PropertyPrice> list = this.propertyPriceService.queryUserByCreateTime();
			return AjaxResponse.success("ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	* @Title: exportPrice 
	* @Description: 导出
	* @param @param suggest
	* @param @param request
	* @param @param response
	* @param @param pageIndex
	* @param @param pageSize    入参
	* @return void    返回类型
	* @author zx   
	* @throws
	* @date ‎2018‎年‎8‎月‎8‎日 ‎18:03:47
	 */
	@RequestMapping("/exportPrice")
	public void exportPrice(PropertyPrice propertyPrice,HttpServletRequest request, HttpServletResponse response,Integer pageIndex,Integer pageSize){
		List<PropertyPrice> list = this.propertyPriceService.selectPageList(propertyPrice, 0, 99999999);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "缴费姓名","公司名","园区","楼号", "室号", "物业费", "水电费","合计金额",
				"应缴时间","缴费状态","实缴时间","收据编号"};
		int colNum = strArr.length;
		int rowNO = 0;
		eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum, "物业相关费用基本信息表");
		rowNO++;
		
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum," "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[list.size()][12];
		for (int i = 0; i < list.size(); i++) {
			PropertyPrice pp = list.get(i);
			strings[i][0] = pp.getName();
			strings[i][1] = pp.getCompany();
			if(pp.getParkNumber().equals("1")){
				strings[i][2] = "创业型企业孵化园区";
			}else if(pp.getParkNumber().equals("2")){
				strings[i][2] = "工业园区";
			}else if(pp.getParkNumber().equals("3")){
				strings[i][2] = "长江市场园区";
			}else if(pp.getParkNumber().equals("4")){
				strings[i][2] = "科技产业园区";
			}else if(pp.getParkNumber().equals("5")){
				strings[i][2] = "电商大楼及物流园区";
			}else{
				strings[i][2] = "未知";
			}
			strings[i][3] = pp.getBuilding();
			strings[i][4] = pp.getRoomNumber();					
			strings[i][5] = pp.getPropertyCharge();	
			strings[i][6] = pp.getHydropowerCharge();
			strings[i][7] = pp.getTotal();
			strings[i][8] = pp.getShouldPayDate();
			if (pp.getPayState()==1) {
				strings[i][9] = "未缴费";
			}else if (pp.getPayState()==2) {
				strings[i][9] = "已缴费";
			}
			strings[i][10] = pp.getPayDate();
			strings[i][11] = pp.getReceiptNumber();
		}
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);
		eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200, "物业相关费用基本信息表", "right");
		// 导出路径
		String fileName = "物业相关费用基本信息表.xls";
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
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 18:04:05
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
	
	//导入·····································································
	/**
	* @Title: importPrice 
	* @Description: 导入
	* @param @param file
	* @param @param session
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date ‎2018‎年‎8‎月‎9‎日 ‎11:24:08
	 */
	@RequestMapping(value = "/importPrice", method = RequestMethod.POST)
	public AjaxResponse importPrice(@RequestParam("file") MultipartFile file, HttpSession session) {
		try {
			List<Map<String, Object>> list 	= new ArrayList<Map<String, Object>>();
			list 							= ExcelUtil.readXls(file);

			List<PropertyPrice> pList 		= new ArrayList<PropertyPrice>();

			for (Map<String, Object> m : list) {

				PropertyPrice pp 			= new PropertyPrice();

				for (String k : m.keySet()) {
				//缴费姓名   公司名	身份证号	园区	楼号	室号	物业费	水电费	合计金额	应缴时间	
					switch (k) {
						case "缴费姓名":
							pp.setName(m.get(k).toString());
							break;
						case "身份证号":
							if(!StringUtil.isEmpty(m.get(k).toString())){
								PropertyPrice pro = propertyPriceService.getByIdCode(m.get(k).toString());
								pp.setUserId(pro.getUserId());
							}
							break;
						case"公司名":
							pp.setCompany(m.get(k).toString());
							break;
						case "园区":
							pp.setParkNumber(m.get(k).toString());
							break;
						case "楼号":
							pp.setBuilding(m.get(k).toString());
							break;
						case "室号":
							pp.setRoomNumber(m.get(k).toString());
							break;
						case "物业费":
							pp.setPropertyCharge(m.get(k).toString());
							break;
						case "水电费":
							pp.setHydropowerCharge(m.get(k).toString());
							break;
						case "合计金额":
							pp.setTotal(m.get(k).toString());
							break;
						case "应缴时间":
							if(!StringUtil.isEmpty(m.get(k).toString())){
								String time = m.get(k).toString();
								String times  = time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, time.length());
								pp.setShouldPayDate(times);
							}
							break;
					}

				}
				Long count = propertyPriceService.getCountByUserId(pp);
				if (count != null && count > 0) {
					continue;
				}else if(StringUtil.isEmpty(pp.getName()) 			|| 
						pp.getUserId() == null 			  			||
						StringUtil.isEmpty(pp.getParkNumber()) 		||
						StringUtil.isEmpty(pp.getBuilding())		||
						StringUtil.isEmpty(pp.getRoomNumber())		||
						StringUtil.isEmpty(pp.getPropertyCharge())	||
						StringUtil.isEmpty(pp.getTotal())			||
						StringUtil.isEmpty(pp.getShouldPayDate())   ||
						pp.getCompany() == null){
					continue;	
				} else {
					pList.add(pp);
				}
			}
			
			if(pList!=null && pList.size()>0){
				for(PropertyPrice pri : pList){
					propertyPriceService.addPropertyPrice(pri);
				}
			}
			
			return AjaxResponse.success("ok","");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	/**
	* @Title: queryTotalByMonth 
	* @Description: 本月各户总费用统计
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎9日 08:58:24
	 */
	@RequestMapping("/queryTotalByMonth")
	public AjaxResponse queryTotalByMonth(String payDate){
		try {
			List<PropertyPrice> list = this.propertyPriceService.queryTotalByMonth(payDate);
			return AjaxResponse.success("ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	* @Title: queryAllTotalByYear 
	* @Description: 按年统计每个月收款总额
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎9日 09:16:33
	 */
	@RequestMapping("/queryAllTotalByYear")
	public AjaxResponse queryAllTotalByYear(String payDate){
		try {
			List<PropertyPrice> list = this.propertyPriceService.queryAllTotalByYear(payDate.substring(0, 4));
			return AjaxResponse.success("ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	/**
	* @Description: 根据userId查询公司
	* @author yihai Zhao
	 */
	@RequestMapping("/getMerchantByUserId")
	public AjaxResponse getMerchantByUserId(@RequestParam("userId")Long userId){
		try {
			List<PropertyPrice> list = this.propertyPriceService.getMerchantByUserId(userId);
			return AjaxResponse.success("ok ", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	/**
	* @Description: 查询所有公司
	* @author yihai Zhao
	 */
	 @RequestMapping("/selectMerchantList")
	  public AjaxResponse selectMerchantList(){
		List<SzMerchant> list = this.szMerchantService.merchantList();
	  return AjaxResponse.success("selectMerchantList ok ",list);
	  }
	 /**
	 * @Description:定时器推送费用催收
	 * @author yihai Zhao
	  */
	 
	 @Scheduled(cron = "0 0 12 * * ?")
	 //@Scheduled(cron = "0 0/1 * * * ?")
	 @Transactional
	 public void checkPrice(){
		 //查询到所有为商户的用户
		 List<SzUser> userByType = this.szUserService.selectUserByType(2);
		 for (SzUser szUser : userByType) {
			 //拿到每个人的id去查询费用
			 List<PropertyPrice> queryList= this.propertyPriceService.queryPriceCountByuserId(szUser.getRid());
			 if(queryList.size()>0){
					for (int i = 0; i < queryList.size(); i++) {
						//给应缴费人推送消息
						this.szUserService.sendWXMessage(queryList.get(i).getOpenId(),"您的物业费或水电费即将到期，请尽快缴费充值！"+"\n"
						+"明细如下："+"\n"+"物业费："+queryList.get(i).getPropertyCharge()+"\n"+"水电费："+queryList.get(i).getHydropowerCharge()
						+"\n"+"总计："+queryList.get(i).getTotal()+"\n"+"温馨提示："+"您可进入智慧园区公众号查询费用详情，支付费用哦，也可直接到物业线下支付！");
						System.out.println("催收人是："+queryList.get(i).getName());
					}
			 }
		 }
	 }
	 
	/** 
     * 生成订单编号 
     * @return 
     */  
    public static synchronized String getOrderNo() {  
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());  
        if(date==null||!date.equals(str)){  
            date = str;  
            orderNum  = 0l;  
        }  
        orderNum ++;  
        long orderNo = Long.parseLong((date)) * 10000;  
        orderNo += orderNum;;  
        return orderNo+"";  
    } 
}
