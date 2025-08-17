package com.example.microservice.controller;

import com.example.microservice.model.User;
import com.example.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

     private final UserService userService;

     @Autowired
     public UserController(UserService userService) {
          this.userService = userService;
     }

     private int parseValue(String value) {
          try {
               return Integer.parseInt(value);
          } catch (Exception e) {
               return 0;
          }
     }

     @GetMapping("/users")
     public String getUsers(Model model) {
          List<User> users = userService.fetchUsers();
          int totalAnkit = users.stream().mapToInt(u -> parseValue(u.getAnkit())).sum();
          int totalNishant = users.stream().mapToInt(u -> parseValue(u.getNishant())).sum();
          int totalShailu = users.stream().mapToInt(u -> parseValue(u.getShailu())).sum();
          int totalDumya = users.stream().mapToInt(u -> parseValue(u.getDumya())).sum();
          int totalSwapnil = users.stream().mapToInt(u -> parseValue(u.getSwapnil())).sum();
          int totalVipib = users.stream().mapToInt(u -> parseValue(u.getVipib())).sum();

          // Format each column total as "count(weighted)"
          String dispAnkit = totalAnkit + "(" + (totalAnkit * 40) + ")";
          String dispNishant = totalNishant + "(" + (totalNishant * 40) + ")";
          String dispShailu = totalShailu + "(" + (totalShailu * 40) + ")";
          String dispDumya = totalDumya + "(" + (totalDumya * 40) + ")";
          String dispSwapnil = totalSwapnil + "(" + (totalSwapnil * 40) + ")";
          String dispVipib = totalVipib + "(" + (totalVipib * 40) + ")";

          // Optionally, compute a grand total across all fields
          int grandCount = totalAnkit + totalNishant + totalShailu + totalDumya + totalSwapnil + totalVipib;
          String grandTotal = grandCount + "(" + (grandCount * 40) + ")";

          model.addAttribute("users", users);
          model.addAttribute("dispAnkit", dispAnkit);
          model.addAttribute("dispNishant", dispNishant);
          model.addAttribute("dispShailu", dispShailu);
          model.addAttribute("dispDumya", dispDumya);
          model.addAttribute("dispSwapnil", dispSwapnil);
          model.addAttribute("dispVipib", dispVipib);
          model.addAttribute("grandTotal", grandTotal);
          return "users";
     }

     @GetMapping("/users/add")
     public String showAddUserForm(Model model) {
          model.addAttribute("user", new User());
          return "add-user";
     }

     @PostMapping("/users/add")
     public String addUser(User user) {
          userService.saveUser(user);
          return "redirect:/users";
     }

     @GetMapping("/users/delete/{id}")
     public String deleteUser(@PathVariable("id") String id) {
          userService.deleteUser(id);
          return "redirect:/users"; // Refresh the page with the updated user list
     }

}