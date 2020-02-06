package com.valueshark.valueshark;

import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
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


//to run these tests, add your environmental variables to each Gradle app in your configurations


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
		assertNotNull(controller);
	}

	@Test
	public void testSplashPage() throws Exception {
		//assert that page loads entire <body>
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<script type=\"text/javascript\" src=\"/js/app.js\"></script>")));
	}

	@Test
	public void testSignUpPage() throws Exception {
		this.mockMvc.perform(get("/signup"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Sign up")));
	}

	@Test
	public void testAboutUsPage() throws Exception {
		this.mockMvc.perform(get("/aboutus"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Chase Tucker")));
	}

	@Test
	public void testLoginPage() throws Exception {
		this.mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Log In")));
	}

	@Test
	public void testSearchRedirectsToNewPage() throws Exception {
		this.mockMvc.perform(get("/stocks/?symbol=tsla"))
				.andDo(print())
				.andExpect(status().is(302));
	}

	//https://stackoverflow.com/questions/15203485/spring-test-security-how-to-mock-authentication
	//checking /myprofile route as a user signed in @with user details
	//these tests require your local db to have the specified user already created
	@Test
	@WithUserDetails("lwilber")
	public void testMyProfilePage() throws Exception {
		this.mockMvc.perform(get("/myprofile"))
				.andDo(print())
				.andExpect(status().isOk());
	}


	@Test
	@WithUserDetails("lwilber")
	public void testMyStocksPage() throws Exception {
		this.mockMvc.perform(get("/stocks"))
				.andDo(print())
				.andExpect(status().isOk());
	}




}
