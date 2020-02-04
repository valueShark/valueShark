package com.valueshark.valueshark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

	@Test
	public void testSplashPage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("Groovy")));
	}

	@Test
	public void testSignUpPage() throws Exception {
		this.mockMvc.perform(get("/signup"))
				.andDo(print())
				.andExpect(content().string(containsString("<label>First Name <input name=\"firstName\"/></label>")));
	}

	@Test
	public void testLoginPage() throws Exception {
		this.mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(content().string(containsString("<label>Password <input type=\"password\" name=\"password\"/></label>")));
	}




}
