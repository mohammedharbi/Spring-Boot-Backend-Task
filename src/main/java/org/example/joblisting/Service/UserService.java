//package org.example.joblisting.Service;
//
//import lombok.RequiredArgsConstructor;
//import org.example.joblisting.API.ApiException;
//import org.example.joblisting.Model.User;
//import org.example.joblisting.Repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    public void register(User user) {
//
//        if (userRepository.findUserByUsername(user.getUsername()) != null) {
//            throw new ApiException("Username already exists");
//        }
//
//        user.setPassword(encoder.encode(user.getPassword()));
//
//        // ✅ Default: USER if not provided
//        if (user.getRole() == null) {
//            user.setRole("USER");
//        }
//
//        userRepository.save(user);
//    }
//
//    public User login(User user) {
//        User dbUser = userRepository.findUserByUsername(user.getUsername());
//
//        if (dbUser == null) throw new ApiException("Invalid username");
//        if (!encoder.matches(user.getPassword(), dbUser.getPassword()))
//            throw new ApiException("Invalid password");
//
//        return dbUser;
//    }
//}
