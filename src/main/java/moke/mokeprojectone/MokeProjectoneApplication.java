package moke.mokeprojectone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = {"moke.mokeprojectone.mapper"})
@SpringBootApplication
public class MokeProjectoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MokeProjectoneApplication.class, args);
	}

}
