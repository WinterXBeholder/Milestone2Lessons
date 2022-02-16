package Lesson06Packages;

import Lesson06Packages.animals.dog;
import Lesson06Packages.insects.Beetle;
import Lesson06Packages.plants.Lily;


public class Farm {

    private dog mitchell;
    private Beetle annoyingBug;
    private Lily tigerLily;

    public Farm() {
        mitchell = new dog();
        annoyingBug = new Beetle();
        tigerLily = new Lily();
    }
}
