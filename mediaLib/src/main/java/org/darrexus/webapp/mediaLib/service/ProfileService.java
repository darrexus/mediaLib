package org.darrexus.webapp.mediaLib.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.darrexus.webapp.mediaLib.database.DatabaseClass;
import org.darrexus.webapp.mediaLib.model.Message;
import org.darrexus.webapp.mediaLib.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfile();
	
	public ProfileService(){
		profiles.put("darrexus", new Profile(1L, "darrexus", "Dare", "Famodimu"));
	}
	
	//returns all profiles
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	//GET
	public Profile getProfile(String userName){
		return profiles.get(userName);
	}
	
	//POST
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getUserName(), profile);
		return profile;
	}
	//PUT
	public Profile updateMessage(Profile profile){
		if(profile.getUserName().isEmpty()){
			return null;
		}
		profiles.put(profile.getUserName(), profile);		
		return profile;
	}
	//DELETE
	public Profile removeMessage(String userName){
		return profiles.remove(userName);
	}
}
