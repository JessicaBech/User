package com.testmongo.user.response;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type User.
 */
@Setter
@Getter
@ToString
public class User {

  private String id;
  private String firstName;
  private String lastName;
  private String emailAddress;
}