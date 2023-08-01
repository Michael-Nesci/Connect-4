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
    }

    public static void play(int pos) throws InvalidPositionException{
        if(pos < 1 || pos > 7){
            throw new InvalidPositionException("Column " + pos + "does not exist.");
        }
    }

    public void showBoard(){
    }
}

class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(){}
    public InvalidPositionException(String message){
        super(message);
    }
}