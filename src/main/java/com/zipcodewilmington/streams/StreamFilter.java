package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;
    private RandomUtils randomUtils = new RandomUtils();
    private PersonFactory personFactory = new PersonFactory();


    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
      //  this(Stream.empty(), null);
        personStream= Stream.iterate(1, n -> n + 1)
                .limit(100)
                .map(n ->personFactory.createRandomPerson());
        startingCharacter = RandomUtils.createString('a', 'z', 1).toUpperCase();

    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
       // this(Stream.empty(), null);
        personStream = Arrays.stream(people).filter(p->p.getName().startsWith(String.valueOf(startingCharacter)));
        this.startingCharacter = String.valueOf(startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
       // this(Stream.empty(), null);
      personStream=  people.stream().filter(p->p.getName().startsWith(String.valueOf(startingCharacter)));
      this.startingCharacter = String.valueOf(startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        return this.personStream.filter(p->p.getName().startsWith(this.startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return this.personStream.filter(p->p.getName().startsWith(this.startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return this.personStream.filter(p->p.getName().startsWith(this.startingCharacter)).toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        return this.personStream.filter(p->p.getName().startsWith(this.startingCharacter)).toArray(Person[]::new);
    }

}
