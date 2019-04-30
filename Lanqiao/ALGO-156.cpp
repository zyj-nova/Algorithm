//
//Author NEFUZYJ
//created time 2019-04-30
//title "表达式求值"
//
#include <iostream>
#include <stack>
#include <string>
using namespace std;
//转化为后缀表达式
string s;
char post[200];
int z = 0;
stack<int> num;
stack<char> opt; //算符栈

int getPriority(char ch)
{
    if (ch == '*' || ch == '/')
        return 2;
    if (ch == '+' || ch == '-')
        return 1;
    return 0;
}
void preTopost()
{
    int len = s.size();

    int nowOrder = 0, topOrder = 0;
    for (int i = 0; i < len; i++)
    {
        if (s[i] >= '0' && s[i] <= '9')
        {
            while (s[i] >= '0' && s[i] <= '9')
            {
                post[z++] = s[i++];
            }
            post[z++] = '#';
            i--;
        }
        else if (s[i] == '(')
            opt.push(s[i]);
        else if (s[i] == ')')
        {
            while (opt.top() != '(')
            {
                post[z++] = opt.top();
                opt.pop();
            }
            opt.pop(); //弹出左括号
        }
        else if (s[i] == '*' || s[i] == '+' || s[i] == '-' || s[i] == '/') //操作符
        {
            if (opt.empty())
                opt.push(s[i]);
            else //判断优先级
            {
                topOrder = getPriority(opt.top());
                nowOrder = getPriority(s[i]);
                if (nowOrder > topOrder)
                    opt.push(s[i]);
                else //栈顶优先级小于等于读到的，弹出栈顶元素，直到栈空或者优先级大于读到的
                {
                    while (nowOrder <= topOrder)
                    {
                        post[z++] = opt.top();
                        opt.pop();
                        if (!opt.empty())
                        {
                            topOrder = getPriority(opt.top());
                        }
                        else
                            break;
                    }
                    opt.push(s[i]);
                }
            }
        }
    }
    while (!opt.empty())
    {
        post[z++] = opt.top();
        opt.pop();
    }
}
int calculate() //计算后缀表达式的值
{
    int a = 0, b = 0;
    for (int i = 0; i < z; i++)
    {
        //遍历表达式，遇到的数字放入栈中
        if (post[i] >= '0' && post[i] <= '9')
        {
            int temp = 0;
            while (post[i] >= '0' && post[i] <= '9')
            {
                temp = temp * 10 + int(post[i] - '0');
                i++;
            }
            num.push(temp);
        }
        else if (post[i] == '#')
        {
            continue;
        }
        else
        {
            switch (post[i])
            {
            case '+':
                a = num.top();
                num.pop();
                b = num.top();
                num.pop();
                num.push(a + b);
                break;
            case '-':
                a = num.top();
                num.pop();
                b = num.top();
                num.pop();
                num.push(b - a);
                break;
            case '*':
                a = num.top();
                num.pop();
                b = num.top();
                num.pop();
                num.push(a * b);
                break;
            case '/':
                a = num.top();
                num.pop();
                b = num.top();
                num.pop();
                num.push(b / a);
                break;
            }
        }
    }
    return num.top();
}
int main()
{
    cin >> s;
    preTopost();
    //cout << post <<endl;
    cout << calculate() << endl;
    return 0;
}
