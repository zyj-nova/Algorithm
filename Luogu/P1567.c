//最长增长序列
#include <stdio.h>
#include <stdlib.h>
int num[1000002],n;
int main()
{
    int i , j, res = 1, maxn = 0;
    scanf("%d",&n);
    for(i = 0; i < n; i++){
        scanf("%d",&num[i]);
    }
    for(i = 0; i < n; i++){
        if(num[i+1] > num[i])
            res++;
        else{
            if(res > maxn){
                maxn = res;
            }
            res = 1;
        }
    }
    printf("%d\n",maxn);
    return 0;
}
