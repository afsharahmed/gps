package jaas;

import javax.security.auth.login.LoginException;

public class TomcatLoginModule extends DbLoginModule {

	@Override
	public boolean commit() throws LoginException {
		if (super.commit()) {
			UserPrincipal userP = new UserPrincipal(getUsername());
			getSubject().getPrincipals().add(userP);
			getPrincipalsAdded().add(userP);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * UserPrincipal is the Principal we specified when configuring the realm for
Tomcat. The user Principal simply wraps the username provided by the user.>
	 */
}