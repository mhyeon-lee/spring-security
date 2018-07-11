package org.springframework.security.oauth2.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Tests for {@link UserInfoRequestSchema}.
 *
 * @author MyeongHyeon Lee
 */
public class UserInfoRequestSchemaTests {

	@Test(expected = IllegalArgumentException.class)
	public void constructorWhenValueIsNullThenThrowIllegalArgumentException() {
		new UserInfoRequestSchema(null);
	}

	@Test
	public void getValueWhenHeaderSchemaTypeThenReturnHeader() {
		assertThat(UserInfoRequestSchema.HEADER.getValue()).isEqualTo("header");
	}

	@Test
	public void getValueWhenFormSchemaTypeThenReturnForm() {
		assertThat(UserInfoRequestSchema.FORM.getValue()).isEqualTo("form");
	}
}
