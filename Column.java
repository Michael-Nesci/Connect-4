public class Column{
    private char col [];
    private int highest;

    public Column(){
        this.col = new char[] { 
                        '_',
                        '_',
                        '_',
                        '_',
                        '_',
                        '_'
                    };
    }

    public int getSize(){
        return col.length;
    }

    public int getHighest(){
        return highest;
    }

    public boolean addToken(char player){
        for(int i = col.length-1; i >= 0; i--){
            if(col[i] == '_'){
                col[i] = player;
                highest = i;
                return true;
            }
        }
        return false;
    }

    public char getToken(int pos){
        return col[pos];
    }

    public void capitalizeToken(int pos){
        col[pos] = Character.toUpperCase(col[pos]);
    }

    @Override
    public String toString(){
        String s = "| ";
        for(int i = 0; i < col.length; i++){
            s += col[i] + "| ";
        }
        return s;
    }
}
