package com.github.novawu.springsample.definition.bean;

public interface DefaultPeopleFactory {

    default People createPeople() {
        People people = new People();
        people.setName("name5");
        people.setId(5L);
        return people;
    }
}
