//package design.zykus.zykus.clothing.Controller;
//
//import design.zykus.zykus.clothing.Entity.PasswordResetToken;
//import design.zykus.zykus.clothing.Entity.WebAppUser;
//import design.zykus.zykus.clothing.Service.PasswordResetService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RestController
//public class PasswordResetController {
//    @Autowired
//    private PasswordResetService passwordResetService;
//
//    @GetMapping("/forgot-password")
//    public String showForgotPasswordForm() {
//        return "forgot-password-form";
//    }
//
//    @PostMapping("/forgot-password")
//    public String processForgotPassword(@RequestParam("email") String email, HttpServletRequest request) {
//        WebAppUser user = passwordResetService.findByEmail(email);
//        if (user != null) {
//            String token = UUID.randomUUID().toString();
//            passwordResetService.createPasswordResetTokenForUser(user, token);
//            // Send an email with the reset link
//        }
//        return "redirect:/forgot-password?success";
//    }
//
//    @GetMapping("/reset-password")
//    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
//        PasswordResetToken passwordResetToken = passwordResetService.getPasswordResetToken(token);
//        if (passwordResetToken == null) {
//            // Handle invalid token
//        } else if (passwordResetToken.isExpired()) {
//            // Handle expired token
//        } else {
//            model.addAttribute("token", token);
//        }
//        return "reset-password-form";
//    }
//
//    @PostMapping("/reset-password")
//    public String processResetPassword(@RequestParam("password") String password, @RequestParam("token") String token) {
//        PasswordResetToken passwordResetToken = passwordResetService.getPasswordResetToken(token);
//        if (passwordResetToken == null || passwordResetToken.isExpired()) {
//            // Handle invalid or expired token
//        } else {
//            passwordResetService.changeUserPassword(passwordResetToken.getUser(), password);
//        }
//        return "redirect:/login?passwordResetSuccess";
//    }
//}
//
