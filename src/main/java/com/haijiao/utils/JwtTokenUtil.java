package com.haijiao.utils;

import com.haijiao.pojo.Admin;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 创建JWT具类
 */
@Component
public class JwtTokenUtil {

	private Clock clock = DefaultClock.INSTANCE;

	// 密钥,从application.properties中读取
	@Value("${jwt.secret}")
	private String secret;

	// jwt失效时间(单位为秒)
	@Value("${jwt.expiration}")
	private Long expiration = 1800L;

	/**
	 * 创建JWT token
	 *
	 * @param
	 * @param
	 * @return
	 */
	public String createJwt(String user) {
		Date now = clock.now();
		// 添加JWT的包含部分，有三部分：头部（header）、载荷（payload）、签证（signature）.
		JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT").setIssuedAt(now) // 设置jwt创建时间
				.setIssuer(user) // 设置当前用户信息
				.setExpiration(calculateExpirationDate(now)) // 设置失效时间
				.setSubject("uid")
				.claim("realname", "匿名")//通过claim()方法可添加若干属性，也可以添加一个对象
				.claim("sex", "不详")
				.claim("weight","2000")
				.signWith(SignatureAlgorithm.HS512, secret);// 设置加密算法、指定密钥
		return jwtBuilder.compact();

	}


	/**
	 *
	 * 获取名字方法
	 *
	 * @param token
	 * @return
	 */

	public String getUsernameByToken(String token){
		try {
			if(token!=null){
				Claims claims=parseJWT(token);
				String username=claims.getIssuer();
				//String usernames=claims.getId();
				//String usernamess=claims.getAudience();
				//String usernamesss=claims.getSubject();
				System.out.println("jwt里面的get方法");
				System.out.println("token="+token);
				System.out.println("username="+username);
				return username;
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return  null;
	}
	/**
	 * 验证JWT
	 *
	 * @return
	 */
	public Claims parseJWT(String token) {
		//根据密钥解析token,解析成功返回Claims;解析不成功会抛出异常
		Claims c = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return c;
	}

	/**
	 * 得到失效时间
	 *
	 * @param createdDate
	 * @return
	 */
	private Date calculateExpirationDate(Date createdDate) {

		return new Date(createdDate.getTime() + expiration * 1000);
	}
}

