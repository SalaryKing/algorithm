public class Test {
    public static void main(String[] args) {
        int[][] a=new int[4][4];
        int i, j, s=0;
        for(i=0; i<4; i++)
            for(j=0; j<4; j++)
                a[i][j]=(i+1)*(j+1);
        for(i=0; i<4; i++)
            s=s+a[3-i][3-i];
        System.out.print(s);
    }
}
