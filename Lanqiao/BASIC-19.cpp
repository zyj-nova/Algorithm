//
//"完美的代价"
//
#include<iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    string s;    
    cin >> s;
    
    int end = n - 1;    //字符串最后一个字符 
    int cnt = 0;        //交换次数 
    int oddNum = 0;        //判断是否已经有一个单独的奇个数的字符了
    
    for (int i = 0; i < end; i++)//从第一个字符到倒数第二个字符遍历 
    {
        for (int j = end; j >= i; j--)//从最后一个开始，到第i个字符，寻找与s[i]相同的字符
        {        
            if (i == j)       //如果没找到 
            {
                if (n % 2 == 0 || oddNum == 1)  //不可能的两种情况 
                {
                    cout << "Impossible";
                    return 0;
                }
                oddNum = 1;            //找到一个字符出现的次数为奇数 
                cnt += n / 2 - i;    //将次字符交换到中间位置的次数 
            } 
            else if (s[i] == s[j])    //如果找到了，将s[j]交换到s[end]位置 
            {
                for (int k = j; k < end; k++)    //交换相邻两个位置的字符 
                {
                    swap(s[k], s[k+1]);
                    cnt++;
                }
                end--;                //末尾递减 
                break;                //开始从i+1处重复操作 
            }
        }
    }
    
    cout << cnt;
    
    return 0;
}