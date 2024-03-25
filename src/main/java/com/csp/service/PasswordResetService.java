package com.csp.service;
 
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
import com.csp.bean.Login;
import com.csp.dao.LoginDao;
 
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
@Service
public class PasswordResetService {
 
	private LocalDateTime creationTime;
	private LocalDateTime expieryTime;
	@Autowired
	private JavaMailSender mailSender;
 
	@Autowired
	private LoginDao loginDao;
 
 
 
	public String updatePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
		Login login = loginDao.findByUserEmailId(email);
		if (login != null) {
			if (login.getPassword().equals(oldPassword)) {
				if (newPassword.equals(confirmPassword)) {
					login.setPassword(newPassword);
		            loginDao.save(login);
					return "Record inserted";
				}else {
					return "new password don't match the Confirm Password";
				}
			} else {
				return "Invalid old password";
			}
 
		} else {
			return "Invalid Email ";
		}

	}
 
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
		mimeMessageHelper.setText("Your CCP Application Password reset verification OTP is: " + otp);
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
		if (creationTime.isAfter(expieryTime.minusMinutes(5)) && (storedOtp != null && storedOtp.equals(otp))) {
				otpStorage.remove(email);
				return true;
			}
		otpStorage.remove(email);
		return false;
	}
 
}
 