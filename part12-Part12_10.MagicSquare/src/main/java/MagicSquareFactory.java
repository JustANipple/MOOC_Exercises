
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare magicSq = new MagicSquare(size);

        //il metodo funziona solo se la larghezza del quadrato è dispari
        if(magicSq.getWidth() % 2 != 0) {
            //bisogna avere un puntatore che parte dalla metà della prima riga
            
            int times = magicSq.getWidth() * magicSq.getWidth();
            
            //bisogna inserire i numeri equivalenti al quadrato della sua length
            int r = 1;
            int c = magicSq.getHeight() / 2 - 1;
            int num = 1;
            for(int i = 0; i < times; i++) {
                r = goUp(magicSq, r);
                c = goRight(magicSq, c);
                //se il valore nelle coordinate è 0, scrivo
                if(magicSq.readValue(c, r) != 0) {
                    c = goLeft(magicSq,c);
                    r = goDown(magicSq,r);
                    r = goDown(magicSq,r);
                    
                }
                magicSq.placeValue(c, r, num);
                
                //aumento il valore di num di 1
                num++;
            }
        }
        return magicSq;
    }
    
    public static int goUp(MagicSquare magicSq,int r) {
        //movimento verso l'alto
        if(r - 1 < 0) {
            r = magicSq.getHeight() - 1;
        } else {
            r--;
        }
        return r;
    }
    
    public static int goRight(MagicSquare magicSq,int c) {
        //movimento verso destra
        if(c + 1 > magicSq.getWidth() - 1) {
            c = 0;
        } else {
            c++;
        }
        return c;
    }
    
    public static int goDown(MagicSquare magicSq,int r) {
        //movimento verso il basso
        if(r + 1 > magicSq.getHeight() - 1) {
            r = 0;
        } else {
            r++;
        }
        return r;
    }
    
    public static int goLeft(MagicSquare magicSq, int c) {
        //movimento verso sinistra
        if(c - 1 < 0) {
           c = magicSq.getWidth() - 1;
        } else {
            c--;
        }
        return c;
    }
}
