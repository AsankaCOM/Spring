package com.ecaphi.cars.bootstrap;

import com.ecaphi.cars.model.Car;
import com.ecaphi.cars.repo.ReservationResository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ReservationResository reservationResositoryRepo;

    public DevBootstrap(ReservationResository reservationResositoryRepo) {
        this.reservationResositoryRepo = reservationResositoryRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData()
    {
        Car car1 = new Car();
        car1.setManufacturer("Acura");
        car1.setCity("Calgary");
        car1.setModel("LX");
        car1.setRegistrationNumber("LXD-1432-001111");

        reservationResositoryRepo.save(car1);

        Car car2 = new Car();
        car2.setManufacturer("BMW");
        car2.setCity("Edmonton");
        car2.setModel("X5");
        car2.setRegistrationNumber("GTD-99999-002");

        reservationResositoryRepo.save(car2);

    }
}
