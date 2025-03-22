package BattleShip;

import java.util.Random;

public class BattleField {
    int size = 10;
    int[][] field = new int [this.size][this.size];
    int proboina = 0; //сколько попаданий по кораблям противника нужно (уже) сделано

    public BattleField()
    {
        for(int i = 0; i < this.size; i++)
            for(int j = 0; j < this.size; j++)
                this.field[i][j] = 0;
    }

    public void fieldFill()
    {
        int x, y, b; //x,y - координаты начала корабля, b - расположение влево, вправо, вверх, вниз от точки начала
        Random rand = new Random();
        int[] shipSizeDefault = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};//размеры доступных кораблей для размещения

        for (int i = 0; i < shipSizeDefault.length; i++)
            proboina += shipSizeDefault[i]; //сколько суммарно раз попасть по кораблям нужно, чтобы победить

        //размещение всех кораблей
        for (int i = 0; i < shipSizeDefault.length; i++) {
            do {
                x = rand.nextInt(this.size);
                y = rand.nextInt(this.size);
                b = rand.nextInt(4);

            } while (!razmetschenie(x, y, b, shipSizeDefault[i]));//true если корабль удалось разместить
        }
    }

    private boolean razmetschenie(int x, int y, int b, int shipSize)
    {
        int razmer = 3*(2+shipSize);
        int count = 0;
        int[][] kletkiForCheck = new int [razmer][2];//координаты клеток поля для проверки, что корабль доступен к размещению

        switch (b){
            case 0:{//направление влево

                    for(int i = x + 1; i > x - shipSize - 1; i--)
                    {
                       for(int j = y - 1; j < y + 2 ; j++) {
                           kletkiForCheck[count][0] = i;
                           kletkiForCheck[count][1] = j;
                           count++;

                       }
                    }
                    if(checkKletki(kletkiForCheck, razmer))
                    {
                        for(int i = x; i > x - shipSize; i--)
                            this.field[i][y] = 1;
                        return true;
                    }
                return false;

            }

            case(1):{//направление вверх

                for(int i = x - 1; i < x + 2; i++)
                {
                    for(int j = y + 1; j > y - shipSize - 1 ; j--) {
                        kletkiForCheck[count][0] = i;
                        kletkiForCheck[count][1] = j;
                        count++;
                    }
                }
                if(checkKletki(kletkiForCheck, razmer))
                {
                    for(int i = y; i > y - shipSize; i--)
                        this.field[x][i] = 1;
                    return true;
                }
                return false;

            }

            case(2):{//направление вправо

                for(int i = x - 1; i < x + shipSize + 1; i++)
                {
                    for(int j = y - 1; j < y + 2 ; j++) {
                        kletkiForCheck[count][0] = i;
                        kletkiForCheck[count][1] = j;
                        count++;
                    }
                }
                if(checkKletki(kletkiForCheck, razmer))
                {
                    for(int i = x; i < x + shipSize; i++)
                        this.field[i][y] = 1;
                    return true;
                }
                return false;
            }

            default:{//направление вниз

                    for(int i = x - 1; i < x + 2; i++)
                    {
                        for(int j = y - 1; j < y + shipSize + 1 ; j++) {
                            kletkiForCheck[count][0] = i;
                            kletkiForCheck[count][1] = j;
                            count++;
                        }
                    }

                    if(checkKletki(kletkiForCheck, razmer))
                    {
                        for(int i = y; i < y + shipSize; i++)
                            this.field[x][i] = 1;
                        return true;
                    }
                    return false;

                }

            }
    }

    private boolean checkKletki(int [][] kletkiForCheck, int razmer)
    {

        for(int i = 0; i < razmer; i++)
        {

            //проверка на выход за границы
            if(kletkiForCheck[i][0] < -1 || kletkiForCheck[i][0] >= this.size + 1 || kletkiForCheck[i][1] < -1 || kletkiForCheck[i][1] >= this.size + 1)
                return false;
            //проверка на свободное место
            if(kletkiForCheck[i][0] >= 0 && kletkiForCheck[i][0] < this.size && kletkiForCheck[i][1] >= 0 && kletkiForCheck[i][1] < this.size)
                if (this.field[kletkiForCheck[i][0]][kletkiForCheck[i][1]] != 0)
                    return false;
        }

        return true;
    }

    public void printField()
    {
        System.out.print("  ");
        for(int i = 0; i < this.size; i++)
            System.out.print(i+" ");
        System.out.println("");
        for(int i = 0; i < this.size; i++)
        {
            System.out.print(i+" ");
            for(int j = 0; j < this.size; j++)
            {
                System.out.print(this.field[j][i]+" ");
            }
            System.out.println("");
        }
    }

    public int vystrel(int x, int y)
    {
        //0 - пустая клетка
        //1 - корабль есть
        //2 - мимо
        //3 - попал
        if(this.field[x][y] == 0)
        {
            this.field[x][y] = 2;
            return 2;
        }

        if(this.field[x][y] == 1)
        {
            this.field[x][y] = 3;
            proboina--;
            return 3;
        }
        return -1;//код ошибки
    }




}
