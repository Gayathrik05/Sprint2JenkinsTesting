package com.csp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmailSendService {
	
	private LocalDateTime creationTime;
	private LocalDateTime expieryTime;

    @Autowired
    private JavaMailSender mailSender;

    private final Map<String, String> otpStorage = new HashMap<>();

    public void sendOtpService(String email) {
        String otp = generateOtp();
        try {
            sendOtpToMail(email, otp);
            otpStorage.put(email, otp); 
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send OTP");
        }
    }

    private void sendOtpToMail(String email, String otp) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Email Verification OTP");
        mimeMessageHelper.setText("Your CCP Application Login OTP is: " + otp); 
        mailSender.send(mimeMessage);
    }
    
    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        creationTime = LocalDateTime.now();
        System.out.println(creationTime);
        return String.valueOf(otp);
    }
 
    public boolean verifyOTP(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        expieryTime = LocalDateTime.now();
        if(creationTime.isAfter(expieryTime.minusMinutes(1)) && (storedOtp != null && storedOtp.equals(otp))) {
                otpStorage.remove(email);
                System.out.println(LocalDateTime.now());
                return true;
            }
        System.out.println(LocalDateTime.now());
        otpStorage.remove(email);
        return false;
    }
}