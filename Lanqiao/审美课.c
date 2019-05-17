#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#include<string.h>
int n,m,ans[1100000],num[50005],res;
int main()
{
    int i,j,temp,max;
    scanf("%d%d",&n,&m);
    for(i = 0; i < n; i++){
        for(j = 0; j < m; j++){
            scanf("%d",&temp);
            num[i] = (num[i]<<1) + temp;
        }
        ans[num[i]]++;
    }
    max = (1 << m) - 1;
    for(i = 0; i < n; i++){
        temp = num[i]^max;
        res += ans[temp];
    }
    printf("%d\n",res/2);
    return 0;
}
