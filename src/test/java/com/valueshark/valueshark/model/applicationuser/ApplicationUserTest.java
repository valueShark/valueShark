package com.valueshark.valueshark.model.applicationuser;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUserTest {

  @Test
  public void testConstructor() {
    ApplicationUser user = new ApplicationUser();
    assertNotNull(user);
  }

  @Test
  public void testGetters() {
    ApplicationUser user = new ApplicationUser("testUser","testUserPassword", "Jane", "Doe", "testUser@gmail.com");
    assertNotNull(user.getUsername());
    assertNotNull(user.getPassword());
    assertNotNull(user.getFirstName());
    assertNotNull(user.getLastName());
    assertNotNull(user.getEmail());
  }
}