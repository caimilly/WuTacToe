package hbcu.stay.ready.wutactoe;

public abstract class Game {

    protected Console console;
    protected Player player;

    public Game(Console console, Player player){
        this.console = console;
        this.player = player;
    }
}
