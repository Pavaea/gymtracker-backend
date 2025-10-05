package com.gymtracker.backend.web;
import com.gymtracker.backend.domain.user.AppUser;
import com.gymtracker.backend.domain.user.AppUserRepository;
import com.gymtracker.backend.domain.user.Role;
import org.springframework.boot.Banner;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder){
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("")
    public Map<String, Object> adminIndex(@AuthenticationPrincipal User user){
        AppUser appUser = appUserRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        List<AppUser> allUsersBesidesHim = appUserRepository.findAll();
        allUsersBesidesHim.remove(appUser);

        Map<String, Object> response = new HashMap<>();
        response.put("username", appUser.getUsername());
        response.put("role", "ADMIN");
        response.put("totalUsers", allUsersBesidesHim.size());
        response.put("users", allUsersBesidesHim);
        return response;
    }

    @GetMapping("/add-user")
    public String adminAddUser(){
        return "admin-add-user";
    }

    @PostMapping("/save-new-user")
    public String adminNewUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role,
                               @AuthenticationPrincipal User user,
                               Model model){
        //load the Admin itself
        AppUser appUser = appUserRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Optional<AppUser> checkIfExists = appUserRepository.findByUsername(username);
        if(checkIfExists.isPresent()){
            return "redirect:/admin/add-user?exists=true";
        }
        //create new User
        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setRole(Role.valueOf(role));
        newUser.setPasswordHash(passwordEncoder.encode(password));
        //save new User
        appUserRepository.save(newUser);

        return "redirect:/admin";
    }

    @GetMapping("/remove-user")
    public String adminRemoveUser(Model model,
        @AuthenticationPrincipal User user){
        //load the Admin itself
        AppUser appUser = appUserRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        //give to the model all other users.
        List<AppUser> allUsersBesidesHim = appUserRepository.findAll();
        allUsersBesidesHim.remove(appUser);
        model.addAttribute("users", allUsersBesidesHim);

        return "admin-remove-user";
    }

    @PostMapping("/remove-chosen-user")
    public String adminRemoveChosenUser(Model model,
            @AuthenticationPrincipal User user,
            @RequestParam("chosen-user") String chosenUser,
                                        @RequestParam("im-sure") String checkbox){
        //load the user to delete from DB
        AppUser userToDelete = appUserRepository.findByUsername(chosenUser)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        //load the logged user
        AppUser loggedUser = appUserRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));

        if (userToDelete.getUsername().equals(loggedUser.getUsername())){
           throw new IllegalArgumentException("Can't delete the logged User");
        }
        if (checkbox.equals("on")){
            appUserRepository.delete(userToDelete);
        }
        return "redirect:/admin";
    }
}
