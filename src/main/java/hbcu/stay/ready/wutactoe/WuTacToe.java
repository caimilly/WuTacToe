package hbcu.stay.ready.wutactoe;

public class WuTacToe extends Game {

    private Board board;
    public WuTacToe(Console console, Player player) {
        super(console, player);
        board = new Board();
    }

    public void start(){
        Boolean playAgain = true;
        while (playAgain){
            String response = console.getStringInput("Do you want to start a new Game?(y/n)");
            if(response.equals("y")|| response.equals("n")){
                playAgain = (response.equals("y"))?true:false;
            }else {
                console.println("Response unknown, please try again");
            }
            if (playAgain) playGame();
        }
        String message = String.format("GoodBye %s, come again!!", player.getName());
        console.println(message);
    }

    private void playGame(){
        boolean isPlayersTurn = true;
        boolean continueRound = true;
        while (continueRound){
            if(isPlayersTurn){
                playersTurn();
                isPlayersTurn = false;
            }else {
                computersTurn();
                isPlayersTurn = true;
            }
            continueRound = (board.spacesAvailable() > 0)? true : false;
        }
        String message = "Game over";
        console.println(board.displaySpacesAvailable());
        console.println(message);

    }

    private void playersTurn(){
      console.println(board.displaySpacesAvailable());
      int row = console.getIntegerInput("Select row");
      int col = console.getIntegerInput("Select col");
      if (board.selectSpace(1, row, col)){
          String message = String.format("You have placed a X at [row %d : col %d]", row, col);
          console.println(message);
      }else {
          String message = String.format("You can not place a X at [row %d : col %d]", row, col);
          console.println(message);
      }
    }

    private void computersTurn(){
        String message = String.format("Computer skips turn, you can go again");
        console.println(message);
    }

    public static void main(String[] args) {
        Console console = new Console(System.in, System.out);
        String name = console.getStringInput("Please Enter your name");
        Player player = new Player(name);
        String message = String.format("Hello %s, welcome!!", player.getName());
        console.println(message);
        WuTacToe wuTacToe = new WuTacToe(console, player);
        wuTacToe.start();
    }
}
