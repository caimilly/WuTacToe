package hbcu.stay.ready.wutactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        board = new Board();
    }

    @Test
    public void isCellEmptyTest(){
        int row = 0;
        int col = 0;
        boolean actual = board.isCellEmpty(row, col);
        Assert.assertTrue(actual);
    }

    @Test
    public void spacesAvailableTest1(){
        int expected = 9;
        int actual = board.spacesAvailable();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void displaySpacesAvailableTest1(){
        String expected = "[r:0,c:0],[r:0,c:1],[r:0,c:2]\n"+
                          "[r:1,c:0],[r:1,c:1],[r:1,c:2]\n"+
                          "[r:2,c:0],[r:2,c:1],[r:2,c:2]";
        String actual = board.displaySpacesAvailable();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displaySpacesAvailableTest2(){
        String expected = "[r:0,c:1],[r:0,c:2]\n"+
                "[r:1,c:0],[r:1,c:1],[r:1,c:2]\n"+
                "[r:2,c:0],[r:2,c:1],[r:2,c:2]";
        int player1 = 1;
        int row = 0;
        int col = 0;
        board.selectSpace(player1, row, col);
        String actual = board.displaySpacesAvailable();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void selectSpaceTest1(){
        int player = 1;
        int row = 0;
        int col = 0;
        Boolean actual = board.selectSpace(player, row, col);
        Assert.assertTrue(actual);

    }

    @Test
    public void selectSpaceTest2(){
        int player1 = 1;
        int player2 = 2;
        int row = 0;
        int col = 0;
        // Player 1 select a space first
        board.selectSpace(player1, row, col);
        Boolean actual = board.selectSpace(player2, row, col);
        Assert.assertFalse(actual);

    }
}
