package willydekeyser.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/public")
    public String public_page() {
        return "public";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String private_page_user(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
    	return "user";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String private_page_admin(Model model, @AuthenticationPrincipal User user) {
    	model.addAttribute("user", user);
    	return "admin";
    }
}