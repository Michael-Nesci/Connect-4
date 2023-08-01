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
                showBoard();
                changePlayer();
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
}

class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(){}
    public InvalidPositionException(String message){
        super(message);
    }
}