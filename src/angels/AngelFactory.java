package angels;

import java.util.LinkedList;
import java.util.List;

public class AngelFactory {
    private static AngelFactory instance = null;
    private List<Angel> angels;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            return instance = new AngelFactory();
        }
        return instance;
    }

    public List<Angel> createAngels(List<String> stringList) {
        angels = new LinkedList<Angel>();
        for (String string : stringList) {
            String[] info = string.split(",");
            switch (info[0]) {
                case "DamageAngel":
                    angels.add(new DamageAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "DarkAngel":
                    angels.add(new DarkAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "Dracula":
                    angels.add(new Dracula(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "GoodBoy":
                    angels.add(new GoodBoy(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "LevelUpAngel":
                    angels.add(new LevelUpAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "LifeGiver":
                    angels.add(new LifeGiver(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "SmallAngel":
                    angels.add(new SmallAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "Spawner":
                    angels.add(new Spawner(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "TheDoomer":
                    angels.add(new TheDoomer(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "XPAngel":
                    angels.add(new XPAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                default:
                    System.out.println("Angel type does not exist!");
            }
        }
        return angels;
    }
}
