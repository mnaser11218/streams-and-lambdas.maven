package com.zipcodewilmington.streams.conversions;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/25/17.
 */
public final class ArrayConverter extends PersonConversionAgent<Person[]> {
  //  private Person[] personArray = (Person[]) Arrays.stream(objectSequence).toArray();
    //private RandomUtils randomUtils = new RandomUtils();
    //this.personStream = conversionAgent.toStream();
//    private personList = conversionAgent.toList();
//        this.personArray = conversionAgent.toArray();

    //   private final Person[] people;

    public ArrayConverter(Person... people) {
        super(people);
      // this.people = people;
    }

    public ArrayConverter(int collectionSize) {
        this(Stream
                .generate(new PersonFactory()::createRandomPerson)
                .limit(collectionSize)
                .toArray(Person[]::new));
//        this.personArray = Stream
//                .generate(new PersonFactory()::createRandomPerson)
//                .limit(collectionSize)
//                .toArray(Person[]::new);
    }

    //TODO
    public List<Person> toList() {

        return Arrays.asList(toArray());
    }

    //TODO
    public Stream<Person> toStream() {

        Stream<Person> results =Arrays.stream(toArray());
        return results;
    }

    @Override
    public Person[] toArray() {
//        Person[]results = (Person[]) Arrays.stream(super.objectSequence).toArray();
//        return results;
        return super.objectSequence;
    }
//    public static Character createCharacter(char min, char max) {
//        return (char) createInteger((int) min, (int) max).intValue();
//    }
//    public static Integer createInteger(Integer min, Integer max) {
//        return createFloat(min, max).intValue();
//    }

}
