package com.example.microservice.controller;

import com.example.microservice.model.User;
import com.example.microservice.model.UserFormData;
import com.example.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

     // Helper to safely parse string to int
     private int parseValue(String value) {
          try {
               return Integer.parseInt(value);
          } catch (NumberFormatException e) {
               return 0;
          }
     }

     @GetMapping("/users")
     public String getUsers(Model model) {
          List<User> users = userService.fetchUsers();

          // Calculate totals for each person
          int totalAnkit = users.stream().mapToInt(u -> parseValue(u.getAnkit())).sum();
          int totalNishant = users.stream().mapToInt(u -> parseValue(u.getNishant())).sum();
          int totalShailu = users.stream().mapToInt(u -> parseValue(u.getShailu())).sum();
          int totalDumya = users.stream().mapToInt(u -> parseValue(u.getDumya())).sum();
          int totalSwapnil = users.stream().mapToInt(u -> parseValue(u.getSwapnil())).sum();
          int totalVipib = users.stream().mapToInt(u -> parseValue(u.getVipib())).sum();

          // Format per-person totals as "count(weighted_value)"
          String formattedAnkitTotal = totalAnkit + "(" + (totalAnkit * 40) + ")";
          String formattedNishantTotal = totalNishant + "(" + (totalNishant * 40) + ")";
          String formattedShailuTotal = totalShailu + "(" + (totalShailu * 40) + ")";
          String formattedDumyaTotal = totalDumya + "(" + (totalDumya * 40) + ")";
          String formattedSwapnilTotal = totalSwapnil + "(" + (totalSwapnil * 40) + ")";
          String formattedVipibTotal = totalVipib + "(" + (totalVipib * 40) + ")";

          // Calculate and format the grand total
          int grandTotalCount = totalAnkit + totalNishant + totalShailu + totalDumya + totalSwapnil + totalVipib;
          String grandTotal = grandTotalCount + "(" + (grandTotalCount * 40) + ")";

          // Add all attributes to the model
          model.addAttribute("users", users);
          model.addAttribute("totalAnkit", formattedAnkitTotal);
          model.addAttribute("totalNishant", formattedNishantTotal);
          model.addAttribute("totalShailu", formattedShailuTotal);
          model.addAttribute("totalDumya", formattedDumyaTotal);
          model.addAttribute("totalSwapnil", formattedSwapnilTotal);
          model.addAttribute("totalVipib", formattedVipibTotal);
          model.addAttribute("grandTotal", grandTotal);

          return "users";
     }

     @GetMapping("/users/add")
     public String showAddUserForm(Model model) {
          model.addAttribute("user", new UserFormData());
          return "add-user";
     }

     @PostMapping("/users/add")
     public String addUser(@ModelAttribute("user") UserFormData formData) {
          User user = new User();
          user.setDate(formData.getDate());

          // Sum Day and Night values
          user.setAnkit(String.valueOf(parseValue(formData.getAnkitDay()) + parseValue(formData.getAnkitNight())));
          user.setNishant(
                    String.valueOf(parseValue(formData.getNishantDay()) + parseValue(formData.getNishantNight())));
          user.setShailu(String.valueOf(parseValue(formData.getShailuDay()) + parseValue(formData.getShailuNight())));
          user.setDumya(String.valueOf(parseValue(formData.getDumyaDay()) + parseValue(formData.getDumyaNight())));
          user.setSwapnil(
                    String.valueOf(parseValue(formData.getSwapnilDay()) + parseValue(formData.getSwapnilNight())));
          user.setVipib(String.valueOf(parseValue(formData.getVipibDay()) + parseValue(formData.getVipibNight())));

          userService.saveUser(user);
          return "redirect:/users";
     }

     @GetMapping("/users/delete/{id}")
     public String deleteUser(@PathVariable("id") String id) {
          userService.deleteUser(id);
          return "redirect:/users";
     }
}