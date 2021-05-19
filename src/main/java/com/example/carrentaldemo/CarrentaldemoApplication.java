package com.example.carrentaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrentaldemoApplication {

//    void call() {
//        int[] aa = new int[] {1,2,3};
//        int b=3;
//        IntStream.of(aa).forEach(x->{
//
//            System.out.println(this.getClass().getName()+ x);
//        });
//    }
public static void main(String[] args) {
    // new CarrentaldemoApplication().call();
    SpringApplication.run(CarrentaldemoApplication.class, args);
}

}
