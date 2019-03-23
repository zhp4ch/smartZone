package com.mass.biz.smart.camera.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.camera.dao.CameraMapper;
import com.mass.biz.smart.camera.model.CameraModel;
import com.mass.biz.smart.camera.service.CameraService;

@Service
public class CameraServiceImpl implements CameraService{

	@Autowired
	private CameraMapper cameraMapper;
	
	@Override
	public CameraModel addEntiy(CameraModel cameraModel) {
		boolean b=0<cameraMapper.insert(cameraModel);
		return b ? cameraModel:null;
	}

	
}
