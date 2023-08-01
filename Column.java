public class Column{
    char[] col = new char[7];

    public Column(){
        char[] col = {  '_',
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

    public boolean addToken(char player){
        for(int i = col.length; i >= 0; i--){
            if(col[i] == '_'){
                col[i] = player;
                return true;
            }
        }
        return false;
    }
}
