package com.example.udemydemo;

import com.example.udemydemo.entity.Author;
import com.example.udemydemo.entity.Course;
import com.example.udemydemo.repository.AuthorRepository;
import com.example.udemydemo.repository.CourseRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UdemyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdemyDemoApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, CourseRepository courseRepository){
        return args -> {

            Faker faker = new Faker();
            List<Course> courseList = new ArrayList<>();

            for (int i = 0; i < 50; i++) {

                for (int j = 0; j < 5; j++) {

                    Course course = Course.builder()
                            .title(faker.name().title())
                            .description(faker.harryPotter().book())
                            .build();
                    Course savedCourse = courseRepository.save(course);

                    courseList.add(savedCourse);
                }

                Author author = Author.builder()
                        .name(faker.name().firstName())
                        .surname(faker.name().lastName())
                        .age(faker.number().numberBetween(18, 60))
                        .email(faker.internet().emailAddress())
                        .courses(courseList)
                        .build();
                authorRepository.save(author);
            }
            //authorRepository.findAllByName("Robbin").forEach(System.out::println);
            //authorRepository.findTop3ByOrderByAgeDesc().forEach(System.out::println);

        };

    }

}

