import java.util.Scanner;

public class UI {

    public static void main(String[] args){
        Connect4 game = new Connect4();

        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
		while (scanner.hasNextInt()){
			int action = scanner.nextInt();
			try{
                game.play(action);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
