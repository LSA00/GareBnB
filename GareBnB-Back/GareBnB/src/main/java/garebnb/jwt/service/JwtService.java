package garebnb.jwt.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("jwtService")
public class JwtService {
	
	
	private final String securitykey = "dkaghghkgksmszl";
	
	private final Long expiredTime = 1000 * 60L * 60L * 24L;
	
	public String generateJwtToken(Map<String , Object> map) {
		Date now = new Date();
		
		String JWT = Jwts.builder()
				.setSubject((String) map.get("MEM_ID"))
				.setHeader(createHeader())
				.setClaims(createClaims(map))
				.setExpiration(new Date(now.getTime() + expiredTime))
				.signWith(SignatureAlgorithm.HS256, securitykey)
				.compact();
		System.out.println("generate pass");
		return JWT;
		
		
	}
	
	public Map<String , Object> createHeader(){

		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		header.put("regDate", System.currentTimeMillis());

		return header;
		
	}
	
	public Map<String, Object> createClaims(Map<String , Object> map) {

		
		String memIdx = ((BigDecimal)map.get("MEM_IDX")).toString();
		String memLevel = ((BigDecimal)map.get("MEM_LEVEL")).toString();
		
		Map<String,Object> claims = new HashMap<>();
		claims.put("MEM_ID", map.get("MEM_ID"));
		claims.put("MEM_IDX", memIdx);
		claims.put("MEM_LEVEL",memLevel);
		System.out.println("pass claims");
		return claims;
	}
	
	private Claims getClaims(String token) {
		
		return Jwts.parser().setSigningKey(securitykey).parseClaimsJws(token).getBody();
	}
	
	public String getMemIdx (String token) {
		return (String) getClaims(token).get("MEM_IDX");
	}
	
	public String getMemLevel (String token) {
		return (String) getClaims(token).get("MEM_LEVEL");
	}
	
	public String getMemId(String token) {
		return (String) getClaims(token).get("MEM_ID");
	}

}
