package com.mass.biz.smart.camera.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mass.biz.smart.camera.model.CameraModel;

@Mapper
public interface CameraMapper {

	int insert(CameraModel cameraModel); 
	
}
