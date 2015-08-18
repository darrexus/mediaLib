package org.darrexus.webapp.mediaLib.database;

import java.util.HashMap;
import java.util.Map;
import org.darrexus.webapp.mediaLib.model.*;

//eventual Database Connection class.
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap();
	private static Map<Long, Profile> profiles = new HashMap();
	
	public static Map<Long, Message> getMessage(){
		return messages;
	}
	
	public static Map<Long, Profile> getProfile(){
		return profiles;
	}

}
