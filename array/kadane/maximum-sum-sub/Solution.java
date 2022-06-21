
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int ans=nums[0];
//         int n=nums.length ;
//         int cur = 0;
//         for(int i=0;i<n;i++){
//             cur+=nums[i];
//              ans=Math.max(cur,ans);
//             cur = Math.max(0, cur);

//         }
//         return ans;
//     }
// }

class Solution {
    public static int maxSubArray(int[] nums) {
        SegmentTree seg = new SegmentTree(nums);
        return seg.find(0, nums.length - 1, 1, 0, nums.length - 1).ans;

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}

class Data {
    public int sum, pre, suf, ans;

    public Data() {
    };

    public Data(int v) {
        sum = v;
        pre = v;
        suf = v;
        ans = v;
    }
}

class SegmentTree {
    Data[] a;
    int[] v;
    int n;

    Data combi(Data l, Data r) {
        Data res = new Data();
        res.sum = l.sum + r.sum;
        res.pre = Math.max(l.pre, l.sum + r.pre);
        res.suf = Math.max(r.suf, l.suf + r.sum);
        res.ans = Math.max(l.suf + r.pre, Math.max(l.ans, r.ans));
        return res;
    }

    public SegmentTree(int[] v) {
        this.v = v;
        int n = v.length;
        a = new Data[4 * n];
        build(0, n - 1, 1);
    }

    void build(int l, int r, int i) {
        if (l == r) {
            a[i] = new Data(v[l]);
            return;
        }
        int m = (l + r) / 2;
        build(l, m, i * 2);
        build(m + 1, r, i * 2 + 1);
        a[i] = combi(a[i * 2], a[i * 2 + 1]);
    }

    public Data find(int l, int r, int i, int x, int y) {
        if (x > y)
            return new Data(Integer.MIN_VALUE);
        if (l == x && y == r)
            return a[i];
        int m = (l + r) / 2;
        return combi(find(l, m, i * 2, x, Math.min(y, m)), find(m + 1, r, i * 2 + 1, Math.max(m + 1, x), y));
    }

    // public update(int l,int r,int i, int x,int v){
    // if(l==r){
    // a[i]=x;
    // return;
    // }
    // int m = (l+r)/2;
    // if(x<=m)
    // update(l,m,i*2,x,v);
    // else
    // update(m+1,r,i*2+1,x,v);
    // a[i] = a[i*2]+ a[i*2+1];
    // }
}