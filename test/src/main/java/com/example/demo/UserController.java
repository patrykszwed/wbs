package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Controller
public class UserController {

    final String username = "myUserWbs@gmail.com";
    final String password = "rootroot1";

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/newUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping("/randomUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", RandomUsersService.getRandomStudents());
        return "results";
    }

    @GetMapping("/evenUsers")
    public String getEvenUsers(Model model) {
        model.addAttribute("users", RandomUsersService.getRandomStudents());
        return "evenResults";
    }

    @PostMapping("/addUser")
    public String submitUser(@Valid @ModelAttribute User greeting, BindingResult result) {
        return result.hasErrors() ? "user-form" : "result";
    }

    @GetMapping("/calculator")
    public String addNumbers(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    @PostMapping("/calculator")
    public String showNumbers(@Valid @ModelAttribute Calculator calculator, BindingResult result) {
        calculator.sum();
        return "calculatorResult";
    }

    @GetMapping("/files")
    public String addFile(Model model) {
        System.out.println("TEST");
        model.addAttribute("file", new User());
        return "uploadForm";
    }

    @RequestMapping(value = "/formUpload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // store the bytes somewhere
            String filePath = request.getServletContext().getRealPath(name);
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("filePath = " + filePath);
            return "uploadSuccess";
        } else {
            return "uploadFailure";
        }
    }

    @GetMapping("/strings")
    public String addStrings(Model model) {
        model.addAttribute("myString", new MyString());
        return "strings";
    }

    @PostMapping("/strings")
    public String showNumbers(@Valid @ModelAttribute MyString myString, BindingResult result) {
        myString.concatenate();
        return "stringsResult";
    }

    @GetMapping("/email")
    public String showEmailPage(Model model) {
        model.addAttribute("email", new MyEmail());
        return "email";
    }

    @PostMapping("/email")
    public String sendEmail(@Valid @ModelAttribute MyEmail email, BindingResult result) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("myUserWbs@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("botqtv@gmail.com"));
            message.setSubject("Mail Subject");

            String msg = email.getEmailText();

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("SUCCESSFULLY SENT");
        return "index";
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }

}