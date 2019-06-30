package design_pattern.blueBridgeCup;

public class ThownEgg {

    public static void main(String[] args) {
        System.out.println(TestTime(3,1000));
    }


    public static int TestTime(int egg, int floor){

        if(egg < 1 || floor < 1) return 0;
        if(egg == 1)return floor;
        int s[][] = new int[egg+1][floor+1];
        //设置每种情况的最差循环次数
        for(int i=1; i<=egg; i++){
            for(int j=1; j<=floor; j++){
                s[i][j] = j;
            }
        }

        //这里的DP的递推公式为f[n][m] = 1+max(f[n-1][k-1],f[n][m-k]) k属于[1,m-1]
        //从1-m层中随机抽出来一层k
        //如果第一个鸡蛋在k层碎了，那么我们将测试1~k-1层，就可以找出来，也即1+f[1][k-1]
        //如果第一个鸡蛋在k层没有碎，那么我们将测试k+1~m也即m-k层，
        //      这里也是重点！！！！
        //      现在我们手里有2个鸡蛋，要测试m-k层，那么我想问，此时和你手里有2个鸡蛋要测试1~m-k层有什么区别？
        //      没有区别！是的在已知k层不碎的情况下，测试k+1~m层的方法和测试1~m-k没区别，所以可以写成 1+f[n][m-k] 其中1表示为 在k层的那一次测试

        for(int i=2; i<=egg; i++){
            for(int j=1; j<=floor; j++){
                for(int k=1; k<j; k++){
                    s[i][j] = Math.min(s[i][j],1+Math.max(s[i][j-k],s[i-1][k-1]));
                }
            }
        }
        return s[egg][floor];
    }
}
