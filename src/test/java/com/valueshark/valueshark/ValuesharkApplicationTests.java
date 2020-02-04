package com.valueshark.valueshark;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValuesharkApplicationTests {

	@Autowired
	ValueSharkController controller;

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
