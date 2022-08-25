package com.cs.leetcode;

public class Test {
    //N children
    //everyone gets 1 candy
    //rating for each children
    //everyone gets 1
    //children with higher rating get more candy then neighbour
    //minimum candies required
//    {1,0,2} => 5
//    {1,2,2} ==> 4
//    {1,3,2} == 4
    public static void main(String[] args) {
        System.out.println(candyDistributor(new int[]{3,2,1}));

    }

    public static int maxSetSize(List<Integer> riceBags) {
        int count=1;
        int max=count;
        int flag=-1;
        List<Integer> dp = new ArrayList<>();
        riceBags.forEach(x->{
            dp.add(-1);
        });
        for(int i = 0; i<riceBags.size(); i++){

            if(dp.get(i) != -1){
                count=1;
                int ele=riceBags.get(i);
                int sq=ele*ele;
                while(riceBags.contains(sq)){
                    sq=sq*sq;
                    count++;
                }
                dp.set(i, count);
            }
            else{
                count = count + dp.get(i);
            }

            if(count>max){
                max=count;
                flag=0;
            }
        }
        if(flag==-1)
            return -1;
        return max;
    }


    private static int candyDistributor(int[] ints) {

        int candyNeeded=0;
        int candyPerKid=2;
        int n=ints.length;

        if(n==0){
            return 0;
        }

        if(n==1){
            return 1;
        }
        for(int i=0;i<n;i++){

            if(i==0){
                if(ints[0]<ints[1])
                    if(candyPerKid>1)
                        candyPerKid--;
            }
            else if(i==n-1){
                if(ints[n-1]<=ints[n-2]) {
                    if (candyPerKid > 1) {
                        candyPerKid--;
                    }
                }
                else
                    candyPerKid++;

            }
            else if((ints[i]<ints[i-1]) || (ints[i]<ints[i+1])){
                if (candyPerKid > 1)
                candyPerKid--;
            }
            else{

                    candyPerKid++;
            }

            System.out.println(candyPerKid);
            candyNeeded=candyPerKid+candyNeeded;

        }

        return candyNeeded;
    }
}
