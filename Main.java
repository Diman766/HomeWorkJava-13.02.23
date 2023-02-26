import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

      // teamInfo(twoTeam);

      Scanner user_input = new Scanner(System.in);


      String stop = "";
      while (stop.equals("")) {
         for (BaseHero unit: twoTeam) {
            unit.Step(twoTeam);
         }
         twoTeam.forEach(n -> System.out.println(n.GetInfo()));
         stop = user_input.nextLine();
      }
      for (BaseHero unit: twoTeam) {
         unit.Step(twoTeam);
      }
      
   }

   public static void getTeam(int quantity,List<BaseHero> team,int whichTeam){
      if (whichTeam == 1){
         for (int index = 0; index < quantity; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Peasant(heroName(),1,1));
                  break;
               case 1:
                  team.add(new Magician(heroName(),1,1));
                  break;
               case 2:
                  team.add(new Crossbowman(heroName(),1,1));
                  break;
               case 3:
                  team.add(new Raider(heroName(),1,1));
                  break;
            }
         }
      }else{
         for (int index = 0; index < quantity; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Farmer(heroName(),10,1));
                  break;
               case 1:
                  team.add(new Monk(heroName(),10,1));
                  break;
               case 2:
                  team.add(new Sniper(heroName(),10,1));
                  break;
               case 3:
                  team.add(new Spearman(heroName(),10,1));
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
