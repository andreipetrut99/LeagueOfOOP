package heroes;

public class Rogue extends Hero {

     public Rogue(int x, int y, String landType) {
         super(x, y, landType);
     }


    @Override
    public void setHp(int hp) {

    }

    @Override
    public void resetHp() {

    }

    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public void attack(Hero hero, char landType) {

    }
}
