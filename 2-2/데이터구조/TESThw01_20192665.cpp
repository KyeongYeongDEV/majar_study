#include <iostream>
#include <vector>
using namespace std;

class Polynomial
{
private:
    int Hight; //최대 차수
    vector<float> f_vec;

public:
    Polynomial()
    {
        Hight = 0;
    }

    void set_f_vec(float tmp)
    {
        f_vec.push_back(tmp);
    }

    void set_num(string str)
    {
        Hight = (int)str[5]-'0';

        for (int i = 0; i < str.length(); i++)
        {
            if ((int)str[i] - '0' >= 0 && (int)str[i] - '0' <= 9)
            {
                f_vec.push_back((int)str[i] - '0');
            }
        }
    }

    void set_hight(int tmp){
        Hight = tmp;
    }

    float get_f_vec(int i)
    {
        return f_vec[i];
    }

    int get_hight()
    {
        return Hight;
    }

    int get_size(){
        return f_vec.size();
    }
};

void add_Poly(Polynomial A, Polynomial B, Polynomial *ret)
{
    int hight = A.get_hight();
    ret->set_hight(hight);
    int tmp = 0;

    for (int i = 0; i <= hight * 3; i++) //다항식 저장
    {
        if(i ==0 || i %3 ==0){
        tmp = A.get_f_vec(i) + B.get_f_vec(i);
        ret->set_f_vec(tmp);}
    }

     
        for (int i = hight * 3; i < hight * 3 + 3; i++)
            { // 상수 저장
                tmp = A.get_f_vec(i) + B.get_f_vec(i);
                ret->set_f_vec(tmp);
            }
     
    
    
}

void sub_Poly(Polynomial A, Polynomial B, Polynomial *ret)
{
    int hight = A.get_hight();
    ret->set_hight(hight);
    int tmp = 0;

    for (int i = 0; i <= hight * 3; i++) //다항식 저장
    {
        if(i ==0 || i %3 ==0){
        tmp = A.get_f_vec(i) + B.get_f_vec(i);
        ret->set_f_vec(tmp);}
    }

    for (int i = hight * 3; i < hight * 3 + 3; i++)
    { // 상수 저장
        tmp = A.get_f_vec(i) + B.get_f_vec(i);
        ret->set_f_vec(tmp);
    }
}

void mult_Poly(Polynomial A, Polynomial B, Polynomial *ret)
{
}

void div_Poly(Polynomial A, Polynomial B, Polynomial *ret)
{
    //나머지도 계산
    //
}

void print_Polynomial(Polynomial _in)
{ //결과를 출력 차수만큼 돌면서 출력
    int hight= _in.get_hight();
    int tmp = hight;
    for (int i = 0; i < hight; i++)
    {
        cout << _in.get_f_vec(i)<<".0x^"<<tmp<<'+';
        tmp--;
    }

   
    cout << _in.get_f_vec(hight)<<".0"<<endl;    
}

int main()
{
    Polynomial A, B, ret;
    string str;
    cout << "A : ";
    cin >> str;
    A.set_num(str);

    cout << "B : ";
    cin >> str;
    B.set_num(str);

    add_Poly(A, B, &ret);
    
}
// 3.0x^5+6.0x^4+0.0x^3+0.0x^2+0.0x^1+10.0

// //상수항 저장 10.0 || 1.0
//      if( ret->get_size() %3 == 0 ){// 상수가 10의 자리수이다.
//         int Atmp = (A.get_f_vec(hight*3)-'0')*10 + (A.get_f_vec(hight*3+1)-'0');
//         int Btmp = (B.get_f_vec(hight*3)-'0')*10 + (B.get_f_vec(hight*3+1)-'0');
//         ret->set_f_vec(Atmp+Btmp);
//      }
//      else{
//          int Ntmp = A.get_f_vec(hight * 3) + B.get_f_vec(hight * 3);
//          ret->set_f_vec(Ntmp);
//      }