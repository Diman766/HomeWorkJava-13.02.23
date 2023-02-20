import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import BaseHero.BaseHero;
import BaseHero.Name;

public class Main {

   public static void main(String[] args) {

      List<BaseHero> red = new ArrayList<>();
      getTeam(10,red,2);
      // teamInfo(red);

      List<BaseHero> blue = new ArrayList<>();
      getTeam(10,blue,1);
      // teamInfo(blue);

      List<BaseHero> twoTeam = new ArrayList<>();
      twoTeam.addAll(red);
      twoTeam.addAll(blue);

      twoTeam.sort(new Comparator<BaseHero>() {
         @Override
         public int compare(BaseHero o1,BaseHero o2){
            if (o2.getSpeed() == o1.getSpeed()) return o2.getHp() - o1.getHp();
            return o2.getSpeed() - o1.getSpeed();
         }
      });

      teamInfo(twoTeam);

   }

   public static void getTeam(int quantity,List<BaseHero> team,int whichTeam){
      if (whichTeam == 1){
         for (int index = 0; index < quantity; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Peasant(heroName()));
                  break;
               case 1:
                  team.add(new Magician(heroName()));
                  break;
               case 2:
                  team.add(new Crossbowman(heroName()));
                  break;
               case 3:
                  team.add(new Raider(heroName()));
                  break;
            }
         }
      }else{
         for (int index = 0; index < quantity; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Farmer(heroName()));
                  break;
               case 1:
                  team.add(new Monk(heroName()));
                  break;
               case 2:
                  team.add(new Sniper(heroName()));
                  break;
               case 3:
                  team.add(new Spearman(heroName()));
                  break;
            }
         }

      }
   }

   public static void teamInfo(List<BaseHero> team) {
      System.out.println("----------------------------");
      for (BaseHero i : team) {
         System.out.println(i.GetInfo());
      }
   }

   public static String heroName() {
      return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
   }
}
