import java.util.ArrayList;

public class Connect4 {
    public ArrayList<Column> columns;
    public char player;

    public Connect4(){
        columns = new ArrayList<Column>();
        for(int i = 0; i < 7; i++){
            columns.add(new Column());
        }
        player = 'x';
        showBoard();
        System.out.println("PLAYER 1'S TURN (X)");
    }

    public void play(int pos) throws InvalidPositionException{
        if(pos < 1 || pos > 7){
            throw new InvalidPositionException("Column " + pos + " does not exist.");
        }
        else{
            if(!columns.get(pos-1).addToken(player)){
                throw new InvalidPositionException("Column " + pos + " is full.");
            }
            else{
                if(checkIfWin(pos)){
                    showBoard();
                    if(player == 'x'){
                        System.out.println("WINNER: PLAYER 1 (X) WINS!");
                    }
                    else{
                        System.out.println("WINNER: PLAYER 2 (O) WINS!");
                    }
                }
                else{
                    showBoard();
                    changePlayer();
                }
            }
        }
    }

    public void showBoard(){
        for(int i = 0; i < columns.get(0).getSize(); i++){
            System.out.print("| ");
            for(int j = 0; j < columns.size(); j++){
                System.out.print(columns.get(j).getToken(i) + " | ");
            }
            System.out.println();
        }
    }

    public void changePlayer(){
        if(player == 'x'){
            player = 'o';
            System.out.println("PLAYER 2'S TURN (O)");
        }
        else{
            player = 'x';
            System.out.println("PLAYER 1'S TURN (X)");
        }
    }

    public void changeDisplay(String type, int pos){
        switch(type){
            case "horizontal":
                int row = columns.get(pos).getHighest();
                for(int i = pos-3; i <= pos; i++){
                    columns.get(i).capitalizeToken(row);
                }
        }
    }

    public boolean checkIfWin(int pos){
        pos--;
        return checkIfHorizontal(pos);
    }

    /* 
    Given the column number (pos), find the row the last token was placed on.
    Check the tokens on that row, from pos-3 to pos+3
    If there are 4+ of the same token in a row at any point, return true
    Else return false
    */
    public boolean checkIfHorizontal(int pos){
        int row = columns.get(pos).getHighest();
        int start = pos-3;
        int end = pos+3;
        if(start < 0){
            start = 0;
        }
        if(end > 5){
            end = 5;
        }
        int count = 0;
        for(int i = start; i <= end; i++){
            if(columns.get(i).getToken(row) == player){
                count++;
                if(count == 4){
                    changeDisplay("horizontal", i);
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }
}

class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(){}
    public InvalidPositionException(String message){
        super(message);
    }
}