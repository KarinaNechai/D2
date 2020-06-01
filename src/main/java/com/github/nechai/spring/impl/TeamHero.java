package com.github.nechai.spring.impl;

import com.github.nechai.spring.ITeamHero;
import com.github.nechai.spring.TimeAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Qualifier("TeamHero")
public class TeamHero implements ITeamHero {
    private List<Hero> listHero;

    @Autowired
    public TeamHero(List<Hero> listHero) {
        this.listHero = listHero;
    }

    public List<Hero> getListHero() {
        return listHero;
    }

    public void setListHero(List<Hero> listHero) {
        this.listHero = listHero;
    }

    @Override
      public String toString() {
        String str="";
        for (Hero h:listHero
             ) {
            str=str+h.getClass().getSimpleName()+" ";
        }
        return "TeamHero{" +
                "listHero=" + str +
                '}' ;
    }

    @Override
    @TimeAnnotation
    public void exec() {
        System.out.println("Hello TimeAnnotation");
    }
}
