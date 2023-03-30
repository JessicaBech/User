package com.testmongo.user.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type User Response.
 */
@Getter
@Setter
public class UserResponse {

  private int totalNumberOfUsers;
  private List<User> userList;
}