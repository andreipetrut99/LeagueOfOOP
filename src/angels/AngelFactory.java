package angels;

import heroes.Hero;

import java.util.List;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
            return instance;
        }
        return instance;
    }

    public void createAngels(final List<String> stringList, final List<Hero> heroes) {
        Angel angel = null;
        for (String string : stringList) {
            String[] info = string.split(",");
            switch (info[0]) {
                case "DamageAngel":
                    angel = new DamageAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2]));
                    break;
                case "DarkAngel":
                    angel = (new DarkAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "Dracula":
                    angel = (new Dracula(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "GoodBoy":
                    angel = (new GoodBoy(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "LevelUpAngel":
                    angel = (new LevelUpAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "LifeGiver":
                    angel = (new LifeGiver(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "SmallAngel":
                    angel = (new SmallAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "Spawner":
                    angel = (new Spawner(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "TheDoomer":
                    angel = (new TheDoomer(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                case "XPAngel":
                    angel = (new XPAngel(Integer.parseInt(info[1]),
                            Integer.parseInt(info[2])));
                    break;
                default:
                    System.out.println("Angel type does not exist!");
            }
            playAngel(angel, heroes);
        }
    }

    private void playAngel(final Angel angel, final List<Hero> heroes) {
            for (Hero hero : heroes) {
                if (angel.getX() == hero.getX()
                        && angel.getY() == hero.getY()) {
                    if (hero.isAlive()) {
                        hero.acceptAngel(angel);
                    }
                    if (!hero.isAlive() && angel instanceof Spawner) {
                        hero.acceptAngel(angel);
                    }
                }
            }
    }
}
