package com.testmongo.user;

import com.testmongo.user.response.User;
import com.testmongo.user.response.UserResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


/**
 * The type User Service.
 */
@Service
@Log4j2
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  /**
   * Get All Users from mongodb
   *
   * @return users
   */
  public UserResponse getUsers(){
    List<User> userList = userRepository.findAll();
    UserResponse users= new UserResponse();
    users.setUserList(userList);
    users.setTotalNumberOfUsers(userList.size());
    return users;
  }

  /**
   * Insert a user in mongodb
   *
   * @param id id
   * @param firstName id
   * @param lastName id
   * @param emailAddress id
   * @return returns the info of inserted user
   */
  public User insertUser(
      String id,
      String firstName,
      String lastName,
      String emailAddress) {

    User userEntities= new User();
    userEntities.setId(id);
    userEntities.setFirstName(firstName);
    userEntities.setLastName(lastName);
    userEntities.setEmailAddress(emailAddress);

    return userRepository.save(userEntities);
  }

  /**
   * Get User By Id
   *
   * @param id id
   * @return returns the info of the user
   */
  public User getUserById(String id) {
    return userRepository.findById(id).get();
  }

  /**
   * Delete a User
   *
   * @param id id
   */
  public void deleteUser(
      String id) {
    userRepository.deleteById(id);
  }


}