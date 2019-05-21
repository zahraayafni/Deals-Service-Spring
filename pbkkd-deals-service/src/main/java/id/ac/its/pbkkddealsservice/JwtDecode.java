package id.ac.its.pbkkddealsservice;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

public class JwtDecode {
	public Integer chekRole(String role, String token) {
		 String[] split_string = token.split("\\.");
	     String base64EncodedBody = split_string[1];

	     Base64 base64Url = new Base64(true);

	     String body = new String(base64Url.decode(base64EncodedBody));
//	     System.out.println("JWT Body : "+body); 
	     
	     final JSONObject obj = new JSONObject(body);
	     
	     String authRole = obj.getString("role");
	     if(role.equals(authRole)) {
	    	 return obj.getInt("userid");
	     } else return null;
	    
	}
}
