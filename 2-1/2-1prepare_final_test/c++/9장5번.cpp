#include<iostream>
using namespace std;

class AbstractGate { // 추상 클래스 
protected:
    bool x, y;
public:
    void set(bool x, bool y) { this->x = x; this->y = y; }
    virtual bool operation()=0;
};

class ANDGate : public AbstractGate{// 둘 다 true여야만 true
public:
    bool operation(){
        if(x == true && y == true) return true;
        else return false;
    }
};

class ORGate : public AbstractGate{//하나라도 true면 true
public:
    bool operation(){
        if(x == true || y == true) return true;
        else return false;
    }
};

class XORGate : public AbstractGate{ //하나라도 false면 false
public:
    bool operation(){
        if( x == y ) return false;
        else return true;
    }
};



int main(){
    ANDGate andGate;
    ORGate orGate;
    XORGate xorGate;
        
    andGate.set(true, false);
    orGate.set(true, false);
    xorGate.set(true, false);
    cout.setf(ios::boolalpha); // 불린 값을 "true", "false" 문자열로 출력할 것을 지시 
    cout << andGate.operation() << endl; // AND 결과는 false 
    cout << orGate.operation() << endl;     // OR 결과는 true 
    cout << xorGate.operation() << endl; // XOR 결과는 true 
}