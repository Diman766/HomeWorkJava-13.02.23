import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import units.*;

public class Main {
   public static List<BaseHero> red = new ArrayList<>();
   public static List<BaseHero> blue = new ArrayList<>();
   public static List<BaseHero> twoTeam = new ArrayList<>();

   public static void main(String[] args) {

      getTeam(10, red, 2);

      getTeam(10, blue, 1);

      twoTeam.addAll(blue);
      twoTeam.addAll(red);

      twoTeam.sort(new Comparator<BaseHero>() {
         @Override
         public int compare(BaseHero o1, BaseHero o2) {
            if (o2.getSpeed() == o1.getSpeed())
               return o2.getHp() - o1.getHp();
            return o2.getSpeed() - o1.getSpeed();
         }
      });

      Scanner user_input = new Scanner(System.in);

      String stop = "";
      while (stop.equals("")) {
         View.view();
         for (BaseHero unit : twoTeam) {
            if (vin(red) == true & vin(blue) == true) {
               unit.Step(twoTeam);
            } else if (vin(red)) {
               View.view();
               System.out.println("Blue Vin !");
               user_input.close();
               return;
            } else if (vin(blue)) {
               View.view();
               System.out.println("Red Vin !");
               user_input.close();
               return;
            }
         }
         // twoTeam.forEach(n -> System.out.println(n.GetInfo()));
         stop = user_input.nextLine();
      }
      user_input.close();
   }

   public static boolean vin(List<BaseHero> team) {
      for (BaseHero unit : team) {
         if (unit.getStatus() != "Die") {
            return true;
         }
      }
      return false;
   }

   public static void getTeam(int quantity, List<BaseHero> team, int whichTeam) {
      if (whichTeam == 1) {
         for (int index = 1; index < quantity + 1; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Peasant(heroName(), index, 10));
                  break;
               case 1:
                  team.add(new Magician(heroName(), index, 10));
                  break;
               case 2:
                  team.add(new Crossbowman(heroName(), index, 10));
                  break;
               case 3:
                  team.add(new Raider(heroName(), index, 10));
                  break;
            }
         }
      } else {
         for (int index = 1; index < quantity + 1; index++) {
            switch (new Random().nextInt(0, 4)) {
               case 0:
                  team.add(new Farmer(heroName(), index, 1));
                  break;
               case 1:
                  team.add(new Monk(heroName(), index, 1));
                  break;
               case 2:
                  team.add(new Sniper(heroName(), index, 1));
                  break;
               case 3:
                  team.add(new Spearman(heroName(), index, 1));
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
