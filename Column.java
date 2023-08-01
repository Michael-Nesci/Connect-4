public class Column{
    private char col [];

    public Column(){
        this.col = new char[] {  '_',
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

    public boolean addToken(char player){
        for(int i = col.length-1; i >= 0; i--){
            if(col[i] == '_'){
                col[i] = player;
                return true;
            }
        }
        return false;
    }

    public char getToken(int pos){
        return col[pos];
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
