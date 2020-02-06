package com.valueshark.valueshark.model.applicationuser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUserTest {

  @Autowired
  PasswordEncoder encoder;

  @BeforeEach
  void setUp() {

  }

  @Test
  public void testConstructor() {
    ApplicationUser user = new ApplicationUser("testUser", encoder.encode("testUserPassword"), "Jane", "Doe", "testUser@gmail.com");
    assertNotNull(user.getUsername());
    assertNotNull(user.getPassword());
    assertNotNull(user.getFirstName());
    assertNotNull(user.getLastName());
    assertNotNull(user.getEmail());
  }
}