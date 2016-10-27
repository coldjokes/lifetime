package me.lifetime.entity.wx;

/**
 * access token
 */
public class AccessToken {

	// access token
	private String accessToken;
	// 过期时间
	private int expiresin;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresin() {
		return expiresin;
	}

	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}

}
