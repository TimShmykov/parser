package ru.TimShmykov.parser.FP;

import java.util.Comparator;
import java.util.List;

public class FunctionalLesson {

    public void creator(){ //анонимные классы?
            Comparator<Integer> comparator = new Comparator<>(){

                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1 - integer; // лямбда выражения ->
                }
            };

            comparator.compare(10,9); // -1
            comparator.compare(4,8); //4



            Computable computable;

            computable = (i1, i2) -> i1 + i2 + 10;

            computable.compute(10,10); //30
        Integer com = computable.compute(20, 20);//50


    }
}
