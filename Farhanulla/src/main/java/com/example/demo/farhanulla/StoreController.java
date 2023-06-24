package com.example.demo.farhanulla;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController implements ApplicationRunner {
	
	private static final Logger logger = LogManager.getLogger(StoreController.class);
	
	private StoreService storeService;
	
	public StoreController(StoreService stroService) {
		super();
		this.storeService = stroService;
	}

	@RequestMapping("/stores")
	public List<Stores> RetrivesAll(){
		logger.debug("Debugging log");
        logger.info("tasmiyakhanum");
		return storeService.RetrivesAll();
		
	}
	
	@RequestMapping("/stores/{StoreId}")
	public Stores retriveallstoreId(@PathVariable String StoreId)
	{
		Stores stores = storeService.retriveallstoreId(StoreId);
		return stores;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("Debugging log");
        logger.info("farhanulla");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
		
	}
	
	

}
