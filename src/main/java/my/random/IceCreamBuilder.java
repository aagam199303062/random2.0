package my.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * An overcomplicated system that allows you to create different combinations of ice cream.
 * @author JediMasterSoda
 */
public class IceCreamBuilder {

  public static void test() throws YouAreAnIdiotException {
    System.out.println(new IceCreamBuilder().randomize().build());
    getBestIceCreamEver();
  }

  public static void getBestIceCreamEver() {
    try {
      String iceCream = new IceCreamBuilder()
        .withFlavor(IceCreamFlavor.STRAWBERRY)
        .withFlavor(IceCreamFlavor.MINT_CHOCOLATE_CHIP)
        .withFlavor(IceCreamFlavor.CHOCOLATE)
        .withTopping(IceCreamTopping.CARAMEL_DRIZZLE)
        .withTopping(IceCreamTopping.WHIPPED_CREAM)
        .withTopping(IceCreamTopping.CHERRY)
        .build();

      System.out.println(iceCream);
    } catch (YouAreAnIdiotException e) {
      e.printStackTrace();
    }
  }

  public enum IceCreamFlavor {
    VANILLA("Vanilla"),
    CHOCOLATE("Chocolate"),
    MINT_CHOCOLATE_CHIP("Mint Chocolate Chip"),
    STRAWBERRY("Strawberry");

    private final String formatted_name;

    private IceCreamFlavor(String formatted_name) {
      this.formatted_name = formatted_name;
    }

    @Override
    public String toString() {
      return this.formatted_name;
    }
  }

  public enum IceCreamTopping {
    CHOCOLATE_DRIZZLE("a Chocolate Drizzle"),
    FUDGE_DRIZZLE("a Hot Fudge Drizzle"),
    CARAMEL_DRIZZLE("a Caramel Drizzle"),
    WHIPPED_CREAM("Whipped Cream"),
    CHERRY("a Cherry"),
    WALNUTS("Walnuts"),
    SPRINKLES("Sprinkles"),
    COOKIE_DOUGH("Cookie Dough"),
    GUMMY_BEARS("Gummy Bears"),
    PEANUT_BUTTER_CUPS("Peanut Butter Cups");

    private final String formatted_name;

    private IceCreamTopping(String formatted_name) {
      this.formatted_name = formatted_name;
    }

    @Override
    public String toString() {
      return this.formatted_name;
    }
  }

  private final List<IceCreamFlavor> iceCreamFlavors;
  private final List<IceCreamTopping> iceCreamToppings;

  public IceCreamBuilder() {
    this.iceCreamFlavors = new ArrayList<>();
    this.iceCreamToppings = new ArrayList<>();
  }

  public IceCreamBuilder withFlavor(IceCreamFlavor iceCreamFlavor) {
    this.iceCreamFlavors.add(iceCreamFlavor);

    return this;
  }

  public IceCreamBuilder withTopping(IceCreamTopping iceCreamTopping) {
    this.iceCreamToppings.add(iceCreamTopping);

    return this;
  }

  public IceCreamBuilder randomize() {
    this.iceCreamFlavors.clear();
    this.iceCreamToppings.clear();

    List<IceCreamFlavor> randomIceCreamFlavors = Arrays.asList(IceCreamFlavor.values());
    List<IceCreamTopping> randomIceCreamToppings = Arrays.asList(IceCreamTopping.values());
    Collections.shuffle(randomIceCreamFlavors);
    Collections.shuffle(randomIceCreamToppings);

    final int numberOfScoops = 1 + new Random().nextInt((IceCreamFlavor.values().length) - 1);

    for(int i = 0; i < numberOfScoops; i++) {
      this.iceCreamFlavors.add(randomIceCreamFlavors.get(i));
    }

    final int numberOfToppings = new Random().nextInt(IceCreamTopping.values().length);

    for(int i = 0; i < numberOfToppings; i++) {
      this.iceCreamToppings.add(randomIceCreamToppings.get(i));
    }

    return this;
  }

  public String build() throws YouAreAnIdiotException {
    if(this.iceCreamFlavors.isEmpty()) throw new YouAreAnIdiotException();

    final int numberOfScoops = this.iceCreamFlavors.size();
    String output = String.valueOf(numberOfScoops) + " scoop" + (numberOfScoops != 1 ? "s" : "") + " of " + this.formatArray(this.iceCreamFlavors) + " ice cream";
    
    if(!this.iceCreamToppings.isEmpty()) {
      output += " with " + this.formatArray(this.iceCreamToppings);
    }

    return output;
  }

  private String formatArray(List<?> array) {
    String output = "";

    for(int i = 0; i < array.size(); i++) {
      final String item = array.get(i).toString();

      if(i == (array.size() - 1) && i != 0) {
        if(array.size() == 2) {
          output += " and " + item;
        } else {
          output += ", and " + item;
        }
      } else {
        if(i == 0) {
          output += item;
        } else {
          output += ", " + item;
        }
      }
    }

    return output;
  }

  public class YouAreAnIdiotException extends Exception {

    private static final long serialVersionUID = -700539335109019040L;

    public YouAreAnIdiotException() {
      super("u need at least one scoop of ice cream man");
    }
  }
}