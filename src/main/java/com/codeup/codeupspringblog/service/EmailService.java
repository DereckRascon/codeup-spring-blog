package com.codeup.codeupspringblog.service;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;




@Service("EmailService")
public class EmailService {

        @Autowired
        public JavaMailSender javamailSender;

        @Value("${spring.mail.from}")
        private String from;

        public void prepareAndSend(Post post) {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setTo(post.getUser().getEmail());
            msg.setSubject("Post Created");
            msg.setText(String.format("Post title: '%s'%nPost body: '%s'", post.getTitle(), post.getBody()));

            try{
                this.javamailSender.send(msg);
            }
            catch (MailException ex) {
                // simply log it and go on...
                System.err.println(ex.getMessage());
            }
        }
    }


