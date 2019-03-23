package com.mass.biz.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

public class Utils {
	/**
	 * 过滤敏感词
	 * @param str 需要过滤的本文内容
	 * @return 过滤后的本文内容
	 */
	public static String FilterText(String str) {
		SensitiveWord sw = new SensitiveWord("CensorWords.txt");  
		sw.InitializationWork();  
		str = sw.filterInfo(str);  
		return str;
	}
	
	/**
	 * 获取文件绝对路径
	 * @param fileName
	 * @return
	 */
	public static String getUrl(String fileName){
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:static//lib//"+ fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String dllPath = file.getPath();
		return dllPath;
	}
}
