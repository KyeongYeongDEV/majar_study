import random

option = ["왼쪽상단","왼쪽하단", "중앙", "오른쪽상단", "오른쪽하단"]
computer_choice = random.choice(option)

user = input("어디를 수비하시겠습니까?")

if computer_choice == user:
    print("수비에 성공했습니다.")
else:
    print("패널티 킥이 성공하였습니다.")