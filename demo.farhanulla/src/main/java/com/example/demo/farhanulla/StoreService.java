package com.example.demo.farhanulla;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class StoreService {

	private static List<Stores> stores = new ArrayList<>();

	static {
		Pharmacy pharmacy1 = new Pharmacy("Pharmacy1","farhanulla", "24/05/2023", Arrays.asList("Doctor1", "Doctor2"));
		Pharmacy pharmacy2 = new Pharmacy("Pharmacy2", "tasmiyakhanum","21/05/2023", Arrays.asList("Doctor3", "Doctor4"));
		Pharmacy pharmacy3 = new Pharmacy("Pharmacy3" ,"tassu","21/05/2023", Arrays.asList("Doctor5", "Doctor6"));
		Pharmacy pharmacy4 = new Pharmacy("Pharmacy4" ,"tassudarling","21/05/2023", Arrays.asList("Doctor7", "Doctor8"));

		List<Pharmacy> pharma1 = new ArrayList<>(Arrays.asList(pharmacy1, pharmacy2, pharmacy3));
		List<Pharmacy> pharma2 = new ArrayList<>(Arrays.asList(pharmacy3, pharmacy4));
		
		
		Stores store1 = new Stores("Store1","new1", pharma1, "yes");

		Stores store2 = new Stores("Store2","new2", pharma2, "yes");
		
		stores.add(store1);
		stores.add(store2);
		

	}

	public List<Stores> RetrivesAll(){
		return stores;
	}

	public Stores retriveallstoreId(String storeId) {
		Predicate<? super Stores> predicate = store -> store.getId().equals(storeId);

		Optional<Stores> optionalstore = stores.stream().filter(predicate).findFirst();

		if (optionalstore.isEmpty())
			return null;

		return optionalstore.get();
	}
	
	

}
