package me.lifetime.service.wx;

import java.util.Arrays;

import me.lifetime.common.AppConsts;
import me.lifetime.util.SHA1;

import org.springframework.stereotype.Service;

/**
 * access token 验证
 */
@Service
public class AccessTokenValidateProcess {

	/**
	 * 验证
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkToken(String signature, String timestamp, String nonce){
		
		String arr[] = new String[]{AppConsts.WX_TOKEN,timestamp,nonce};
		//排序
		Arrays.sort(arr);
		
		//生成字符串
		StringBuffer content = new StringBuffer();
		for(String s:arr){
			content.append(s);
		}
		//sha1加密
		String temp = SHA1.hex_sha1(content.toString());
		return temp.equals(signature);
	}
}
