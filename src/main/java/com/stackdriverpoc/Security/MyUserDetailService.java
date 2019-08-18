//package com.stackdriverpoc.Security;
//
//import com.stackdriverpoc.Model.User;
//import com.stackdriverpoc.Model.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import javax.transaction.Transactional;
//
//@Service("userDetailService")
//@Transactional
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) {
//
//        User user = userRepo.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User Not Found");
//        }
//
//        return new MyUserPrincipal(user);
//    }
//}
