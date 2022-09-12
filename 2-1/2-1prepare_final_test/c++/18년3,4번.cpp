#include<iostream>
#include<string>
using namespace std;

class MyString{
private: 
    int m_nLen;
    char *m_pStr;
public:
    MyString ();
    MyString(const char *str);
    ~MyString();
    friend ostream &operator << (ostream & os, MyString &temp);
    //friend MyString operator-(MyString &temp1, MyString &temp2);

        MyString operator + (const MyString &str){
        MyString tmp;
        int cnt=0;
        tmp.m_nLen = this->m_nLen + strlen(str.m_pStr);
        tmp.m_pStr = new char[tmp.m_nLen+1];

        for(int i = 0; i < this->m_nLen; i++){
            tmp.m_pStr[cnt++] = this->m_pStr[i];
        }
         for(int i = 0; i < strlen(str.m_pStr); i++){
            tmp.m_pStr[cnt++] = str.m_pStr[i];
        }

        return tmp;
    }

};


ostream &operator << (ostream & os, MyString &temp){ 
    for(int i =0 ; i < temp.m_nLen; i++){
        os<<temp.m_pStr[i];
    }
    return os;    
}


MyString::MyString(){
    m_nLen =1;
    m_pStr=new char[m_nLen];
    strcpy(m_pStr,"");
}

MyString::MyString(const char*str){
    m_nLen = strlen(str);
    m_pStr = new char[m_nLen];
    strcpy(m_pStr,str);
}

MyString::~MyString(){
    delete[] m_pStr;
    m_nLen = 0;
    m_pStr = NULL;
}

int main(){
    MyString strA("Banana");
    MyString strB("Orange");
    MyString strC;
    MyString strD;
    MyString strE;

    //<<연산자 오버로딩
    cout << "strA=> " << strA <<endl;
    cout << "strB=> " << strB <<endl;
    //출력 결과 Banana
    //        Orange

    // = 연산자 오버로딩, 복사생성자 생성
    strE = strA;

    // + 연산자의 오버로딩
    strC = strA + strB;
    cout << "strC = " << strC <<endl;
    //출력결과 ; strC  = BananaOrange;

    // - 연산자 오버로딩
    // strD = strA-strB;
    //strB에 포함된 모든 문자를 strA에서 삭제
    cout<< "strD = " << strD <<endl;
    //출력결과 : strD = BOrge, a 모두 삭제, n도 모두 삭제
}