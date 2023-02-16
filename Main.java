import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import BaseHero.BaseHero;
import BaseHero.Name;

public class Main {

   public static void main(String[] args) {

      List<BaseHero> red = redTeam(10);
      teamInfo(red);

      List<BaseHero> blue = blueTeam(10);
      teamInfo(blue);
      
   }

   public static List<BaseHero> blueTeam(int quantity) {
      List<BaseHero> blue = new ArrayList<>();

      for (int index = 0; index < quantity; index++) {
         switch (new Random().nextInt(0, 3)) {
            case 0:
               blue.add(new Peasant(heroName()));
               break;
            case 1:
               blue.add(new Magician(heroName()));
               break;
            case 2:
               blue.add(new Crossbowman(heroName()));
               break;
            case 3:
               blue.add(new Raider(heroName()));
               break;
         }
      }
      return blue;
   }

   public static List<BaseHero> redTeam(int quantity) {
      List<BaseHero> red = new ArrayList<>();

      for (int index = 0; index < quantity; index++) {
         switch (new Random().nextInt(0, 3)) {
            case 0:
               red.add(new Farmer(heroName()));
               break;
            case 1:
               red.add(new Monk(heroName()));
               break;
            case 2:
               red.add(new Sniper(heroName()));
               break;
            case 3:
               red.add(new Spearman(heroName()));
               break;
         }
      }
      return red;
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
