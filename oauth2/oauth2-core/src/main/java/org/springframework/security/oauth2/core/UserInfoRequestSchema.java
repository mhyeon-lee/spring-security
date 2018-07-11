package org.springframework.security.oauth2.core;

import java.io.Serializable;

import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

/**
 * This section defines three methods of sending bearer access tokens in resource requests to resource servers.
 *  Clients MUST NOT use more than one method to transmit the token in each request.
 *
 * <p>
 * The OAuth 2.0 Authorization Framework defines three standard request schema types:
 * Authorization Request Header Field, Form-Encoded Body Parameter and URI Query Parameter.
 * It also provides an extensibility mechanism for defining additional request schema types.
 *
 * Because of the security weaknesses associated with the URI method,
 * including the high likelihood that the URL containing the access token will be logged,
 * it SHOULD NOT be used unless it is impossible to transport the access token in the
 * "Authorization" request header field or the HTTP request entity-body.
 * Resource servers MAY support this method.
 *
 * @author MyeongHyeon Lee
 * @since 5.1
 * @see <a target="_blank" href="https://tools.ietf.org/html/rfc6750#section-2">Section 2 Authenticated Requests</a>
 */
public final class UserInfoRequestSchema implements Serializable {
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	public static final UserInfoRequestSchema HEADER = new UserInfoRequestSchema("header");
	public static final UserInfoRequestSchema FORM = new UserInfoRequestSchema("form");
	private final String value;

	/**
	 * Constructs an {@code UserInfoRequestSchema} using the provided value.
	 *
	 * @param value the value of the userInfo request schema type
	 */
	public UserInfoRequestSchema(String value) {
		Assert.hasText(value, "value cannot be empty");
		this.value = value;
	}

	/**
	 * Returns the value of the userInfo request schema type.
	 *
	 * @return the value of the userInfo request schema type
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		UserInfoRequestSchema that = (UserInfoRequestSchema) obj;
		return this.getValue().equals(that.getValue());
	}

	@Override
	public int hashCode() {
		return this.getValue().hashCode();
	}
}
