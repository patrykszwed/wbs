package com.wbs.demo;

import com.wbs.HibernateUtil;
import com.wbs.entity.PetEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("It is running! :)");
        String name, species;
        char sex;
        Integer id;
        System.out.println("These are all pets:");
        List<PetEntity> petEntityList = getAllPetsList();
        petEntityList.forEach(pet -> {
            System.out.println("id = " + pet.getId());
            System.out.println("name = " + pet.getName());
            System.out.println("species = " + pet.getSpecies());
            System.out.println("sex = " + pet.getSex());
            System.out.println("---------------------------");
        });
        System.out.println("Give me the pet Id, I'll give you its name.");
        id = Integer.parseInt(reader.readLine());

        String petName = getNameByPetId(id);
        System.out.println("Pet with id = " + id + " has name " + petName);
        System.out.println("Now we will insert new pet into database.");
        System.out.println("What is it name?");
        name = reader.readLine();
        System.out.println("What is it species?");
        species = reader.readLine();
        System.out.println("What is it sex? (f/m)");
        sex = reader.readLine().charAt(0);
        insertPetIntoDb(name, species, sex);
        System.out.println("New pet has been added into database!");
    }

    private static void insertPetIntoDb(String name, String species, char sex){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Add new Pet object
        PetEntity petEntity = new PetEntity();
        petEntity.setName(name);
        petEntity.setSpecies(species);
        petEntity.setSex(sex);

        // Save the pet in database
        session.save(petEntity);

        // Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    private static String getNameByPetId(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("id = " + id);
        Query query = session.createQuery("from PetEntity where id=:id");
        query.setParameter("id", id);
        PetEntity petEntity = (PetEntity) query.uniqueResult();
        session.close();
        //HibernateUtil.shutdown();
        return petEntity == null ? "There is not pet with id " + id : petEntity.getName();
    }

    private static List getAllPetsList(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        List<PetEntity> petEntityList = session.createQuery("from PetEntity ").list();
        session.close();
        //HibernateUtil.shutdown();
        return petEntityList;
    }
}
