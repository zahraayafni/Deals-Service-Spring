package id.ac.its.pbkkddealsservice;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyPair;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;

import org.springframework.core.io.ClassPathResource;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtDecode {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public static RSAPublicKey get(String privateKey) throws IOException {
	
//		System.out.println(new FileReader(this.getClass().getResource(privateKey).getFile()));
		 try {
			 PEMParser pemParser = new PEMParser(new StringReader(privateKey));
			 JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
			 
			 Object object = pemParser.readObject();
			 KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
			 
	         return (RSAPublicKey) kp.getPublic();
		 } catch (JWTVerificationException exception) {
			 return null;
		 }
	}
	
	private String readFile(String fileName) throws IOException {

		InputStream input = new ClassPathResource(fileName).getInputStream();
		byte[] bytes = IOUtils.toByteArray(input);
		return new String(bytes);
	}

	public DecodedJWT verifyToken(String token) throws Exception {
		try {
			RSAPublicKey publicKey = get(readFile("key/jwtRS256.key"));//Get the key instance
			
			Algorithm algorithmRSCheck = Algorithm.RSA256(publicKey, null);
			JWTVerifier verifier = JWT.require(algorithmRSCheck).withIssuer("tcdelivery").build(); // Reusable verifier																				// instance
			return verifier.verify(token);
		} catch (JWTVerificationException exception) {
			// Invalid signature/claims
			return null;
		}
	}
}
