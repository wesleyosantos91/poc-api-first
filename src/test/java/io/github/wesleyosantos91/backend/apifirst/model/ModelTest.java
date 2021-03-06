package io.github.wesleyosantos91.backend.apifirst.model;

import io.github.wesleyosantos91.backend.apifirst.utils.GetterAndSetterTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
class ModelTest {

    Set<Class<? extends Serializable>> allClasses;
    GetterAndSetterTester tester;

    @BeforeEach
    public void setUp() {
        tester = new GetterAndSetterTester();
        Reflections reflections = new Reflections("io.github.wesleyosantos.apifirst.model");
        allClasses = reflections.getSubTypesOf(Serializable.class);
    }

    @Test
    @DisplayName("Deve Testar todas as entidades")
    void testarTodasEntidades() {
        for (Class<? extends Object> clazz : allClasses)
            tester.testClass(clazz);
    }
}
