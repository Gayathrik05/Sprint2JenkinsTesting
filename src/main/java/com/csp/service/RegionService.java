package com.csp.service;
 

import com.csp.bean.Region;
import com.csp.dao.RegionDao;
import com.csp.dto.RegionDTO;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
public class RegionService {
 
    @Autowired
    private RegionDao regionDao;
 
    public boolean saveOrUpdateRegion(Region region) {
        regionDao.save(region);
        return true;
    }
 
    public boolean deleteRegionById(Long regionId) {
        regionDao.deleteById(regionId);
        return true;
    }
    public List<RegionDTO> findRegionById(Long regionId) {
        Region region=regionDao.findById(regionId).get();
        List<RegionDTO> regionList=new ArrayList<>() ;
        RegionDTO regiondto=new RegionDTO();
        regiondto.setRegionId(region.getRegionId());
    	regiondto.setRegionName(region.getRegionName());
    	regiondto.setRegionLocation(region.getRegionLocation());
    	regiondto.setRegionTimezone(region.getRegionTimezone());
    	regionList.add(regiondto);
        return regionList;
    }
 
    public List<RegionDTO> getAllRegions() {
        Iterator<Region> iterator = regionDao.findAll().iterator();
        List<RegionDTO> userList = new ArrayList<>();
        while (iterator.hasNext()) {
        	Region region=iterator.next();
        	RegionDTO regiondto=new RegionDTO();
        	regiondto.setRegionId(region.getRegionId());
        	regiondto.setRegionName(region.getRegionName());
        	regiondto.setRegionLocation(region.getRegionLocation());
        	regiondto.setRegionTimezone(region.getRegionTimezone());

            userList.add(regiondto);
        }
        return userList;
    }
}