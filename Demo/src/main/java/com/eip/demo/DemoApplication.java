package com.eip.demo;

import com.eip.demo.service.ReservationService;
import com.eip.demo.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class DemoApplication implements CommandLineRunner {
public class DemoApplication {


    @Autowired
	private ReservationService reservationService;

	@Autowired
	private SupportService supportService;



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("+++++++++Running Router Example++++++++");
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("*******Running CLR**********");
//		reservationService.addReservationRecord("1", "John Joe");
//		reservationService.addReservationRecord("2","Joe Jay");
//		reservationService.completeReservation("1", "test");

//		supportService.openTicket("ABC Company", "high", "Urgent Support needed");

//	}
}
