package com.restaurant.booking.config;

import com.restaurant.booking.service.Impl.ReservationServiceImpl;
import com.restaurant.booking.service.ReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ReservationService reservationService1() {
        return new ReservationServiceImpl();
    }

}
