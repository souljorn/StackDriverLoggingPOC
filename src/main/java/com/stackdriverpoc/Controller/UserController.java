//package com.stackdriverpoc.Controller;
//
//import com.stackdriverpoc.Model.UserRepo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(StarshipController.class);
//
//   private final UserRepo userRepo;
//
//   UserController(UserRepo userRepo){
//       this.userRepo = userRepo;
//   }
//
//   @RequestMapping(value = "/username", method = RequestMethod.GET)
//   @ResponseBody
//    public String getUserNameContext(){
//       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//           String currentUserName = authentication.getName();
//           return currentUserName;
//   }
//}
