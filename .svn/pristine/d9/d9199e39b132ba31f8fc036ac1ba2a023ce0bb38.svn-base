package com.mass.biz.smart.property.equipments.controller;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.mass.biz.smart.property.equipments.model.Equipments;
import com.mass.biz.smart.property.equipments.service.EquipmentsService;
import com.mass.biz.utils.ExcelUtil;
import com.mass.core.framework.aop.LogAop;

import com.mass.core.utils.AjaxResponse;

/**
 * 
 * @Title: EquipmentsController.java
 * @Package com.mass.biz.smart.property.equipments.controller
 * @Description: TODO(设备控制层 sz_device_info)
 * @author hq
 * @date 2018年8月16日 下午12:44:24
 * @Since jdk 1.8
 * @version V1.0
 */

@RestController
@RequestMapping("/equipments")
public class EquipmentsController {

	@Autowired
	private EquipmentsService equipmentsService;

	/**
	 * 
	 * @Title:selectMessageList
	 * @Description:(分页条件查询设备)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/selectEquipments")
	public AjaxResponse selectMessageList(Equipments equipments,
			@RequestParam("page") Integer pageIndex,
			@RequestParam("limit") Integer pageSize) {
		return equipmentsService
				.selectPageList(equipments, pageIndex, pageSize);
	}

	/**
	 * 
	 * @Title:insertEquipments
	 * @Description:(新增设备信息)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/insertEquipments")
	public AjaxResponse insertEquipments(Equipments equipments) {
		Integer data = equipmentsService.insertEquipments(equipments);
		if (data != 1) {
			return AjaxResponse.error("no", data);
		} else {
			return AjaxResponse.success("ok", data);
		}
	}

	/**
	 * 
	 * @Title:selectById
	 * @Description:(通过ID查询设备)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/selectById")
	public AjaxResponse selectEquipmentsById (Long rid) {
		Equipments equipments = equipmentsService.selectByPrimaryKey(rid);
		return AjaxResponse.success(equipments);
	}

	
	/**
	 * 
	 * @Title:updateEquipments
	 * @Description:(修改设备信息)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/updateEquipments")
	public AjaxResponse updateEquipments(Equipments equipments) {
		Integer data = equipmentsService.updatEquipments(equipments);
		if (data != 1) {
			return AjaxResponse.error("no", data);
		} else {
			return AjaxResponse.success("ok", data);
		}
	}

	/**
	 * 
	 * @Title:delectById
	 * @Description:(删除设备信息)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/delectById")
	public AjaxResponse delectById(Long rid) {
		Integer data = equipmentsService.delectEquipments(rid);
		if (data != 1) {
			return AjaxResponse.error("no", data);
		} else {
			return AjaxResponse.success("ok", data);
		}
	}

	/**
	 * 
	 * @Title:selectByDeviceNo
	 * @Description:(条件查询设备编号是否重名)
	 * @return:AjaxResponse(返回类型)
	 * @author:hq
	 * @throws
	 */
	@RequestMapping("/selectByDeviceNo")
	public AjaxResponse selectByDeviceNo(String deviceNo) {
		List<Equipments> data = equipmentsService.selectByDeviceNo(deviceNo);
		if (data.size() >= 1) {
			return AjaxResponse.success("存在编号,不可新增。", data.size());
		} else {
			return AjaxResponse.success("无该编号，可以新增", data.size());
		}
	}

	/**
	 * 批量插入数据
	 * 
	 * @param id
	 * @return
	 */

	@LogAop(menuName = "Excel信息", operationDesc = "批理插入", operationType = "1")
	@RequestMapping(value = "/batchImport", method = RequestMethod.POST)
	@Transactional
	public AjaxResponse batchInsert(@RequestParam("file") MultipartFile file,
			HttpSession session) {
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list = ExcelUtil.readXls(file);

			List<Equipments> equipmentslist = new ArrayList<Equipments>();

			for (Map<String, Object> m : list) {

				Equipments equipments = new Equipments();

				for (String k : m.keySet()) {
					switch (k) {
					case "设备编号":
						List<Equipments> data = equipmentsService.selectByDeviceNo(m.get(k).toString());
						if(data.size() >= 1){
							return AjaxResponse.error("notOnly", data.size());
						}
						equipments.setDeviceNo(m.get(k).toString());
						break;
					case "物品单价":
						equipments.setDeviceUnitPrice(m.get(k).toString());
						break;
					case "设备名称(中文)":
						equipments.setcDeviceName(m.get(k).toString());
						break;
					case "设备名称(英文)":
						equipments.seteDeviceName(m.get(k).toString());
						break;
					case "国别":
						equipments.setCountry(m.get(k).toString());
						break;

					case "生产厂家":
						equipments.setFactory(m.get(k).toString());
						break;
					case "出厂日期":
						equipments.setFactoryTime(m.get(k).toString());
						break;
					case "所属单位":
						equipments.setOwnUnit(m.get(k).toString());
						break;
					case "运行状态":
						if (m.get(k).toString().equals("运行中")) {
							equipments.setDeviceState((byte) 1);
						} else if (m.get(k).toString().equals("未运行")) {
							equipments.setDeviceState((byte) 0);
						} else {
							equipments.setDeviceState((byte) 3);
						}
						break;
					case "放置地点":
						equipments.setPlaceLocation(m.get(k).toString());
						break;
					case "联系人":
						equipments.setContact(m.get(k).toString());
						break;
					case "联系人电话":
						equipments.setContactPhone(m.get(k).toString());
						break;
					case "设备类型":
						if (m.get(k).toString().equals("小型")) {
							equipments.setDeviceType((byte) 0);
						} else if (m.get(k).toString().equals("中型")) {
							equipments.setDeviceType((byte) 1);
						} else {
							equipments.setDeviceType((byte) 3);
						}
						break;
					case "主要用途":
						equipments.setMainUse(m.get(k).toString());
						break;
					case "操作说明":
						equipments.setInstructions(m.get(k).toString());
						break;
					case "登记时间":
						equipments.setCreateTime(m.get(k).toString());
						break;
					default:
						break;
					}
				}
				equipmentslist.add(equipments);

			}
			int count = list.size();
			int a = equipmentsService.BatchInsert(equipmentslist);
			return a>0?AjaxResponse.success("ok",count):AjaxResponse.success("error",count);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}

}
