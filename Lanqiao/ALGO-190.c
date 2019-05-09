//素因子去重
#include <stdio.h>
#include <stdlib.h>

typedef long long ll;
ll n, p = 1, i, temp;
int main()
{

    scanf("%I64d", &n);
    temp = n;
    for (i = 2; i * i <= temp; i++)
    {
        if (n % i == 0)
        {
            p *= i;
            while (n % i == 0)
            {
                n /= i;
            }
        }
    }
    printf("%I64d\n", p * n);
    return 0;
}
