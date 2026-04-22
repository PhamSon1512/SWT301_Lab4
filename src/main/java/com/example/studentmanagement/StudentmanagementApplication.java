package com.example.studentmanagement;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class StudentmanagementApplication {

	public static void main(String[] args) {
		// Tắt chế độ headless để có thể sử dụng java.awt.Desktop mở trình duyệt
		new SpringApplicationBuilder(StudentmanagementApplication.class)
				.headless(false)
				.run(args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openBrowser() {
		String url = "http://localhost:8080";
		System.out.println("Application is ready! Opening browser at: " + url);
		
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			try {
				String os = System.getProperty("os.name").toLowerCase();
				if (os.contains("win")) {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} else if (os.contains("mac")) {
					Runtime.getRuntime().exec("open " + url);
				} else if (os.contains("nix") || os.contains("nux")) {
					Runtime.getRuntime().exec("xdg-open " + url);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
