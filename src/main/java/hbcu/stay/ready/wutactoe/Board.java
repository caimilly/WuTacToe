package hbcu.stay.ready.wutactoe;

public class Board {
    private int[][] cells = {{-1,-1,-1},// [x0,y0], [x0,y1], [x0, y2]
                             {-1,-1,-1},// [x1,y0], [x1,y1], [x1, y2]
                             {-1,-1,-1}};//[x2,y0], [x2,y1], [x2, y2]

    public Board(){}

    public Boolean isCellEmpty(int row, int col){
        return (cells[row][col] == -1);
    }
    /*int value = cells[row][col];
    boolean response = false;
    if(value == -1){
        response = true;
    }*/

    public String getPlayerInCell(int row, int col){
        return (cells[row][col] == 1)? "You":"Comp";
    }

    public Integer spacesAvailable(){
        int availableCells =0;
        for(int x =0; x < cells.length; x++){
            availableCells += spacesInColAvailable(x);
        }
        return availableCells;
    }

    private Integer spacesInColAvailable(int row){
        int availableCells = 0;
        for(int y= 0; y < cells[row].length; y++){
            if (isCellEmpty(row,y)){
                availableCells++;
            }
        }
        return availableCells;
    }

    public String displaySpacesAvailable(){
        String output = "";
        for(int x=0; x < cells.length; x++){
            output += displaySpacesInColAvailable(x);
            if(x != cells.length-1) {
                output += "\n";
            }
        }
        return output;
    }

    private String displaySpacesInColAvailable(int row){
        String output = "";
        for(int y = 0; y < cells[row].length; y++){
            if(isCellEmpty(row, y)) {
                output += String.format("[r:%d,c:%d]", row, y);

            }else {
                String playerOrComputer = getPlayerInCell(row, y);
                String message = String.format("[%s]", playerOrComputer);
                output += message;
            }
            if (y != cells[row].length - 1) {
                output += ",";
            }
        }
        return output;
    }

    public Boolean selectSpace(int player, int row, int col){
        if(!isCellEmpty(row,col)){
            return false;
        }
        cells[row][col] = player;
        return true;
    }

}
