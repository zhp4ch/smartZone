package com.mass.biz.utils;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil {
	
	public static List<Map<String, Object>> readXls(MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		// 循环工作表Sheet
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			Map<Object, String> key = new HashMap<Object, String>();
			// 循环行Row
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				
				// 循环列Cell
				// ExcelBean eb = new ExcelBean();
				Map<String, Object> values = new HashMap<String, Object>();
				for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {
					HSSFCell hssfCell = hssfRow.getCell(cellNum);
					if (hssfCell == null) {
						continue;
					}else hssfCell.setCellType(hssfCell.CELL_TYPE_STRING);
					Object value;
					value = getValue(hssfCell, key.get("TYPE" + String.valueOf(cellNum)));
//					if(cellNum==0)//如果第一列为空
//					{
//					  if (StringUtil.isEmpty((String) value) || "null".equals((String) value)) continue;
//					}
					// 取第二行的值作为key
					if (rowNum == 0) {
						String tmp = (String) value;
						if (!StringUtil.isEmpty(tmp) && !"null".equals(tmp)) {
							key.put(cellNum, (String) value);
						}
					} else{
						if (key.containsKey(cellNum)) {
							values.put(key.get(cellNum), value);
						}
					}
				}
				if (!StringUtil.isMapEmpty(values)) {
					list.add(values);
				}
			}
		}
		//hssfWorkbook.close();			
		return list;
	}   
	
	
    @SuppressWarnings("static-access")
	private static Object getValue(HSSFCell hssfCell, String type) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue()).trim();
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(hssfCell)) {
				Date theDate = hssfCell.getDateCellValue();
				SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
				return dff.format(theDate);
			} else {
				if ("String".equals(type) || "int".equals(type)) {
					DecimalFormat df = new DecimalFormat("0");
					String tmp = df.format(hssfCell.getNumericCellValue());
					if ("String".equals(type)) {
						return tmp;
					} else {
						return Integer.valueOf(tmp);
					}
				} else {
					return hssfCell.getNumericCellValue();
				}
			}
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue()).trim();
		}
	}

}
