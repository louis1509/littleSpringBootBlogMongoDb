package application.repositories;

import java.util.List;

import application.domains.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Author, String> {

    public Author findByFirstName(String firstName);
    public List<Author> findByLastName(String lastName);

}
