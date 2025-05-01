package com.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.rest.dao.StockRepository;
import com.rest.entity.Stock;
import com.rest.exception.ResourceAlreadyExistException;
import com.rest.exception.ResourceNoptFoundException;


@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepo;
	
      public Stock CreateStock(Stock newStock) 
    {
    	  Boolean isStock=false;
    	  if(ObjectUtils.isEmpty(isStock)) {
    		  
    		  throw new ResourceAlreadyExistException("Stock is Available Exist");
    		  
    	  }else {
    		  return  stockRepo.save(newStock);
    	  }
   
	
    }
	
	
	public void readStock(){
		
		stockRepo.findAll();
	}
	
	
	public void getOneStock(Integer id) {
		 
	
		stockRepo.findById(id);
	 }
	 
//	public void getOneStock(String name) {
//		 stockRepo.findByName(name);
//	 }
	 public void IncreseStock(Stock newStock) {
		 
	 }
	 
	 
	 
	 public void DeleteStock() {
		 Boolean existingStock=null;
		 
		 if(ObjectUtils.isEmpty(existingStock))
		 {
			 throw new ResourceNoptFoundException("Stock is not found with same id:");
		 }
		 else {
			 stockRepo.delete(null);
		 }
	 }
	

	
	
	
	
}
