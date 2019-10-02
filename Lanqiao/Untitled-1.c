#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//判断输入的字符串是否属于集合{a,b,c,d},aaabcd正确，adbc错误
//设置变量flaga，若出现flaga变为1,若d出现，flagd变为1
char test(char data[])
{
    int flaga = 0, flagd = 0, i, len = strlen(data), flag = 0;
    for (i = 0; i < len; i++)
    {
        if (data[i] == 'a' && (flag == 0 || flag == 1))
        {
            flag = 1;
            flaga = 1;
        }
        else if (data[i] == 'b' && (flag == 1 || flag == 2))
        {
            flag = 2;
        }
        else if (data[i] == 'c' && (flag == 2 || flag == 3))
        {
            flag = 3;
        }
        else if (data[i] == 'd' && (flag == 3 || flag == 4))
        {
            flagd = 1;
            flag = 4;
        }
        else
        {
            return 'N';
        }
    }
    if (flaga == 1 && flagd == 1)
    {
        return 'Y';
    }
    else
    {
        return 'N';
    }
}

int main()
{
    char data[100], result;
    scanf("%s", &data);
    result = test(data);
    scanf("%c", result);
}