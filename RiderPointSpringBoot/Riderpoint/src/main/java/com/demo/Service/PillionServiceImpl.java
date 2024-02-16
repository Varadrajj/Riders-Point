package com.demo.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dao.PillionRouteDetailsDao;
import com.demo.Dao.PillionStatusDao;
import com.demo.Dao.RpDetailsDao;
import com.demo.Dto.RpDetailDTO;
import com.demo.Model.Pillion_Status;
import com.demo.Model.Pillion_route_details;
import com.demo.Model.RpDetails;

@Service
public class PillionServiceImpl implements PillionService {
	
	@Autowired
	private RpDetailsDao rp_details_dao;
	@Autowired
	private PillionStatusDao ps_dao;
	@Autowired 
	private PillionRouteDetailsDao prd_dao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RpDetails> getAll() {
		return rp_details_dao.getAllPillions();
	}

	@Override
	public Pillion_Status addStatus(Pillion_Status pstatus) {
		return ps_dao.save(pstatus);
		
	}

	@Override
	public Pillion_route_details addPillionRoute(Pillion_route_details proute) {
		return prd_dao.save(proute);
	}

	@Override
	public List<Pillion_route_details> getByRoute(String start_point, String end_point) {
		List<Pillion_route_details> plist= prd_dao.getByRoute(start_point,end_point);
		return plist;
	}


	@Override
	public RpDetailDTO getPillionById(String id) {
		int pid=Integer.parseInt(id);
		RpDetails rp=rp_details_dao.findPillionById(pid);
		return modelMapper.map(rp, RpDetailDTO.class);
	}

}
