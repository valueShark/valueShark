package com.valueshark.valueshark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ValuesharkApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ValueSharkController controller;


	//checking controller
	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

	@Test
	public void testSplashPage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<script type=\"text/javascript\" src=\"/js/app.js\"></script>")));
	}

	@Test
	public void testSignUpPage() throws Exception {
		this.mockMvc.perform(get("/signup"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<label>Last Name <input name=\"lastName\"/></label>")));
	}

	@Test
	public void testLoginPage() throws Exception {
		this.mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<label>Username <input class=\"loginfields\" name=\"username\"/></label>")));
	}

	//https://stackoverflow.com/questions/15203485/spring-test-security-how-to-mock-authentication
	//checking /myprofile route as a user signed in @with user details
	@Test
	@WithUserDetails("ran")
	public void testMyProfilePage() throws Exception {
		this.mockMvc.perform(get("/myprofile"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<h1>My profile</h1>")));
	}


	@Test
	@WithUserDetails("ran")
	public void testMyStocksPage() throws Exception {
		this.mockMvc.perform(get("/stocks"))
				.andDo(print())
				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<input name=\"pricePerShare\" type=\"text\"/>")));
	}




}
