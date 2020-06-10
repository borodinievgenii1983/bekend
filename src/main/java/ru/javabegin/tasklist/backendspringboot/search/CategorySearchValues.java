package ru.javabegin.tasklist.backendspringboot.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

// возможные значения, по которым можно искать категории
public class CategorySearchValues {

    private String title; //такое же название должно быть у объекта на фронтенде

}
