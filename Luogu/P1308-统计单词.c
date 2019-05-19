#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include<math.h>
char str[1000009],word[15],temp[1000005][50];
int main()
{
    int len1,len2,i = 0,j = 0,flag = 0,times = 0,posi = 0;
    scanf("%s",word);
    getchar();
    scanf("%[^\n]s",str);
    //fgets(str,1000001,stdin);
    len1 = strlen(word);
    len2 = strlen(str);
    //printf("%d\n",len2);
    //同意转换为小写
    for(i = 0; i < len1; i++){
        if(word[i] >= 'A' && word[i] <= 'Z')
            word[i] += 32;
    }
    for(i = 0; i < len2; i++){
        if(str[i] >= 'A' && str[i] <= 'Z')
            str[i] += 32;
    }
    i = 0;
    while(str[i]!='\0'){
        if(str[i] == ' '){
            temp[j][flag] = '\0';
            flag = 0;
            j++;
        }else
            temp[j][flag++] = str[i];
        i++;
    }
    temp[j][--flag] = '\0';
    for(i = 0; i <= j; i++){
        if(strcmp(temp[i],word)==0){
            if(times == 0)
                flag = i;//在第几个单词出现
            times++;
        }
    }
    if(times != 0){
        if(flag == 0)
            posi = 0;
        else{
         for(i = 0; i < flag ; i++){
            posi += strlen(temp[i]) + 1;
         }
        }
        printf("%d %d\n",times,posi);
    }else{
        printf("-1\n");
    }

    return 0;
}