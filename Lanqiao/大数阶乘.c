#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#include <string.h>
int res[10005], n, digit, num, i, j, temp;
//num 处理进位
int main()
{
    scanf("%d", &n);
    res[0] = 1;
    digit = 1;
    for (i = 2; i <= n; i++)
    {
        num = 0;
        for (j = 0; j < digit; j++)
        {
            temp = res[j] * i + num;
            res[j] = temp % 10;
            num = temp / 10;
        }
        while (num)
        {
            res[digit] = num % 10;
            digit++;
            num /= 10;
        }
    }
    for (i = 0; i < digit; i++)
    {
        if (res[i])
        {
            printf("%d\n", res[i]);
            break;
        }
    }
    return 0;
}
