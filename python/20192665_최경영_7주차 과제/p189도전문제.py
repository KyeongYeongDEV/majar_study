import random

list1 = "한 점의 의심도 없이 맞습니다."
list2 ="할 수 있습니다."
list3 ="물론입니다."
list4 ="글쎄요. 열심히 해야 할 것입니다."
list5 ="안 될 것 같습니다."
list6 ="조금 더 노력하세요."
list7 ="행운을 빕니다."
list8 ="다음 달에 할 수 있을 겁니다."

while True: 
    name = input("이름: (종료하려면 엔터키) ")   
    if name == '':        
        break;    
    question = input("무엇에 대하여 알고 싶은가요? ")    
    print(name, "님", "\"", question ,"\"에 대하여 질문 주셨군요.")    
    print("운명의 주사위를 굴려볼게요...")    
    number = random.randint(1,8)    
    if number == 1:
        print(list1)
    elif number == 2:
        print(list2)
    elif number == 3:
        print(list3)
    elif number == 4:
        print(list4)
    elif number == 5:
        print(list5)
    elif number == 6:
        print(list6)
    elif number == 7:
        print(list7)
    else:
        print(list8)