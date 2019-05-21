#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include<math.h>
#include<memory.h>
char words[4][105],total[450][26],num[26];
int main()
{
    int i,j,len,max = 0;
    for(i = 0; i < 450; i++)
        for(j = 0; j < 26; j++)
        total[i][j] = ' ';
    for(i = 0; i < 4; i++){
        fgets(words[i],105,stdin);
        len = strlen(words[i]);
        for(j = 0; j < len; j++){
            if(words[i][j] >= 'A' && words[i][j] <= 'Z')
                num[words[i][j] - 'A']++;
        }
    }
    for(i = 0; i < 26; i++)
        max = num[i] > max ? num[i]:max;
    for(i = 0; i < 26; i++){
        for(j = 0; j < num[i]; j++){
            total[j][i] = '*';
        }
    }
    for(i = max-1; i >= 0; i--)
       for(j = 0; j < 26; j++){
        printf("%c%c",total[i][j],j == 25?'\n':' ');
       }
    for(i = 0; i < 26; i++){
        printf("%c%c",'A' + i,i == 25?'\n':' ');
    }
    return 0;
}
