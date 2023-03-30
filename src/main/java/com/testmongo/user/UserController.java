package com.testmongo.user;

import com.testmongo.user.response.User;
import com.testmongo.user.response.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type User Controller.
 */
@RestController
@RequestMapping(value = "user")
@Tag(name = "User Controller")
@AllArgsConstructor
@Validated
@Log4j2
public class UserController {

  private final UserService userService;

  /**
   * Get Users.
   *
   * @return the response entity
   */
  @GetMapping("")
  public ResponseEntity<?> getUsers() {
    log.info("Invoke getUsers Method");

    /*
    Set response message
    */
    UserResponse userResponse= userService.getUsers();
    /*
    Return success entity
    */
    log.info("Exit sendMail Method, response is: {}", userResponse);
    return ResponseEntity.status(HttpStatus.OK).body(userResponse);
  }

  /**
   * Insert Users.
   *
   * @return the response entity
   */
  @PostMapping("")
  public ResponseEntity<?> insertUser(
      @Valid @RequestBody User request) {
    log.info("Invoke insertUser Method");

    /*
    Set response
    */
    User response =
        userService.insertUser(request.getId(),
        request.getFirstName(),
        request.getLastName(),
        request.getEmailAddress());
    /*
    Return success entity
    */
    log.info("Exit sendMail Method, response is: {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Get User By Id.
   *
   * @return the response entity
   */
  @GetMapping(value = "/{userId}")
  public ResponseEntity<?> getUserById(@PathVariable(value = "userId") String id) {
    log.info("Invoke getUserById Method");

    /*
    Set response message
    */
    User response = userService.getUserById(id);

    /*
    Return success entity
    */
    log.info("Exit getUserById Method, response is: {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  /**
   * Delete User.
   *
   * @return the response entity
   */
  @DeleteMapping(value = "/{userId}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "userId") String id) {
    log.info("Invoke insertUser Method");

    /*
    Set response message
    */
    User user= userService.getUserById(id);
    userService.deleteUser(id);

    /*
    Return success entity
    */
    log.info("Exit deleteUser Method, response is: {}", user);
    return ResponseEntity.status(HttpStatus.OK).body( "User "+ id + " was Deleted");
  }
}