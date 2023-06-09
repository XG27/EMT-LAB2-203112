package com.example.emtlab2.dataholder;

import com.example.emtlab2.model.Author;
import com.example.emtlab2.model.Book;
import com.example.emtlab2.model.Country;
import com.example.emtlab2.model.enumerations.Category;
import com.example.emtlab2.repository.AuthorRepository;
import com.example.emtlab2.repository.BookRepository;
import com.example.emtlab2.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public List<Book> books = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();
    public List<Country> countries = new ArrayList<>();

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataHolder(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {

        //Countries init
        countries.add(new Country("Germany","Europe"));
        countries.add(new Country("Macedonia","Europe"));
        countries.add(new Country("Japan","Asia"));
        countries.add(new Country("Italy","Europe"));
        countries.add(new Country("South Korea","Asia"));
        countries.add(new Country("Brazil","South America"));

        this.countryRepository.saveAll(countries);

        //Authors init
        authors.add(new Author("James","Patterson",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Gjorgi","Lazarev",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("William","Shakespeare",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("CJ","Box",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Colleen","Hooover",countries.get((int) (Math.random() * countries.size()))));

        this.authorRepository.saveAll(authors);

        //Books init
        books.add(new Book("Anna Karenina", Category.FANTASY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Don Quixote", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("The Adventures of Huckleberry ", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("War and Peace", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("The Lion, the Witch, and the Wardrobe", Category.BIOGRAPHY,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Goce Delcev ", Category.THRILLER,authors.get((int) (Math.random() * authors.size())),50));
        books.add(new Book("Pinocchio", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),50));

        this.bookRepository.saveAll(books);

    }
}