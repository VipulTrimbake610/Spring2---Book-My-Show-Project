package com.acciojob.BookMyShow.Project.Services;

import com.acciojob.BookMyShow.Project.Repository.UserRepository;
import com.acciojob.BookMyShow.Project.Requests.AddUserRequest;
import com.acciojob.BookMyShow.Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser(AddUserRequest userRequest){
        User user = User.builder()
                .age(userRequest.getAge())
                .name(userRequest.getName())
                .emailId(userRequest.getEmailId())
                .mobileNo(userRequest.getMobileNo())
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userRequest.getEmailId());
        mailMessage.setFrom("springacciojob@gmail.com");
        mailMessage.setSubject("Welcome to book my show application !!");

        String body = "Hi" + userRequest.getName() + " !"+
                "Welcome to my Book My Show Application, Enjoy Welcome10 to get 10% off on tickets.";
        mailMessage.setText(body);
        javaMailSender.send(mailMessage);

        user = userRepository.save(user);
        return "User has been saved to the Db with userId "+user.getUserId();
    }
}
