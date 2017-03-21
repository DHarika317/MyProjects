package org.javahd.rest.dao;

import java.util.HashMap;

public class DaoFactory {
	public static HashMap<String, MainDao> daoRepo; //key value pairs of classname and dao object
	static{daoRepo = new HashMap<>();} 
	
	public static MainDao getdao(String daoClass){
		MainDao dao = (MainDao)daoRepo.get(daoClass);
		if(dao==null){
			System.out.println("The "+daoClass+" has no object. Creating....");
			try {
				Class c = Class.forName("org.javahd.rest.dao."+daoClass);
				dao = (MainDao)c.newInstance();
				daoRepo.put(daoClass, dao);
				System.out.println("The object for "+daoClass+" is created and stored in daorepo");
			} catch (Exception e) {e.printStackTrace();} 	
		}else{
			System.out.println("The object for "+daoClass+" exists. Returning....");
		}
		return dao;
		
	}
}
