//package org.example.joblisting.Controller;
//
//import lombok.RequiredArgsConstructor;
//import org.example.joblisting.API.ApiResponse;
//import org.example.joblisting.Model.User;
//import org.example.joblisting.Config.JWT.JwtUtil;
//import org.example.joblisting.Service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//
//    private final UserService userService;
//    private final JwtUtil jwtUtil;
//
//    @PostMapping("/signup")
//    public ResponseEntity signup(@RequestBody User user) {
//        userService.register(user);
//        return ResponseEntity.ok(new ApiResponse("User registered"));
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody User user) {
//
//        User loginUser = userService.login(user);
//
//        String token = jwtUtil.generateToken(loginUser.getUsername(), loginUser.getRole());
//
//        return ResponseEntity.ok(new ApiResponse("Bearer " + token));
//    }
//}
