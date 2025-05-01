package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Stock;
import com.rest.service.StockService;

@RestController  

public class StockController {
	
	@Autowired
	public StockService stockServiceRef;
	
	//http://localhost:8084/stocks/add
	@PostMapping("/stocks/add")
	  public String CreateStock(@RequestBody Stock newStock) 
	    {
		  try {
			  stockServiceRef.CreateStock(newStock);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		  return "Stock Created Successfully!";
	    }
	
	//http://localhost:8084/stocks
	@GetMapping("/stocks/all")
	public void readStocks() {	
	stockServiceRef.readStock();
			
	}
	
	@GetMapping("/stocks/{id}")	
    public String getOneStock(@PathVariable Integer id) {
	
    	try {
    		stockServiceRef.getOneStock(id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return "get Stock succesfully!";
  }
    
	
	    //http://localhost:8084/stocks/id
        @DeleteMapping("/stocks/{id}")	
	    public String DeteteStock(@PathVariable String name) {
		
	    	try {
	    		//stockServiceRef.DeleteStock(name);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    	
	    	return "Stock deleted succesfully!";
	  }
        
        
        

}
