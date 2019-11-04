package example.jwt.dto;

import java.util.Date;
import java.util.Set;

public class StatusDTO {

	private String principalName;
	private Set<String> tokenGroups;
	private String tokenIssurer;
	private Date expirationTime;
	
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public Set<String> getTokenGroups() {
		return tokenGroups;
	}
	public void setTokenGroups(Set<String> tokenGroups) {
		this.tokenGroups = tokenGroups;
	}
	public String getTokenIssurer() {
		return tokenIssurer;
	}
	public void setTokenIssurer(String tokenIssurer) {
		this.tokenIssurer = tokenIssurer;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	
}
