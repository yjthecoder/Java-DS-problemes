package jiuzhang.java.elementary;
// 1
public class AplusB {
    public int aplusb(int a, int b) {
        //两数相加相加转化为和的部分加上carry部分，如果没有carry部分，则只返回和
        if (b == 0) {
            return a;
        } else {
            //规模缩小：每次pass arg到function之前都会左移一位(右边补0)，总体有趋向0的趋势
            return aplusb(a ^ b, (a & b) << 1);
        }
    }
}

// 关键在于用bit 的视角看问题


