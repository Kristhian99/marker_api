package com.example.demo;

import com.example.demo.market.Fruit;
import com.example.demo.repository.FruitRepository;
import com.example.demo.market.Kind;
import com.example.demo.repository.UserRepository;
import com.example.demo.users.STATE;
import com.example.demo.users.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository Repository, MongoTemplate mongoTemplate, FruitRepository repository){
		return args -> {


			Fruit apple=new Fruit(Kind.APPLE,12,343,6,718,812);
			Fruit banana=new Fruit(Kind.BANANA,23,324,6,478,985);
			Fruit orange=new Fruit(Kind.ORANGE,45,234,534,73,984);
			Fruit strawberry=new Fruit(Kind.STRAWBERRY,159,341,56,783,981);
			Fruit cherry=new Fruit(Kind.CHERRY,176,34,563,783,938);

			repository.findFruitByKind(Kind.APPLE).ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()-> {
								System.out.println("Inserting");
								repository.insert(apple);
							});
			repository.findFruitByKind(Kind.BANANA).ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()-> {
								System.out.println("Inserting");
								repository.insert(banana);
							});
			repository.findFruitByKind(Kind.ORANGE).ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()-> {
								System.out.println("Inserting");
								repository.insert(orange);
							});
			repository.findFruitByKind(Kind.STRAWBERRY).ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()-> {
								System.out.println("Inserting");
								repository.insert(strawberry);
							});
			repository.findFruitByKind(Kind.CHERRY).ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()-> {
								System.out.println("Inserting");
								repository.insert(cherry);
							});



			User student=new User(

					"badbunny@gmail.com",
					STATE.ADMIN,
					"admin"

			);
			User student1=new User(

					"badbunny@gmail.com1",
					STATE.USER,
					"user"

			);
			//UsingMongoTemplate(Repository, mongoTemplate, student);

				Repository.findUserByEmail("badbunny@gmail.com").ifPresentOrElse
						(s ->
				System.out.println(s +"Alredy exist"),
				()->{
				System.out.println("Inserting");
				Repository.insert(student);
			});
			Repository.findUserByEmail("badbunny@gmail.com1").ifPresentOrElse
					(s ->
									System.out.println(s +"Alredy exist"),
							()->{
								System.out.println("Inserting");
								Repository.insert(student1);
							});
		};
	}

	private void UsingMongoTemplate(UserRepository Repository, MongoTemplate mongoTemplate, User student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is("badbunny@gmail.com"));

		List<User> students= mongoTemplate.find(query, User.class);

		if(students.size()>1){
			throw new IllegalStateException("Found many students "+"badbunny@gmail.com");
		}
		if(students.isEmpty()){
			System.out.println("Inserting");
			Repository.insert(student);
		}
		else {
			System.out.println(student +"Alredy exist");
		}
	}

}
