import turtle
t = turtle.Turtle()
t.shape("turtle")
t.width(3)

t. shapesize(3,3)

while(True):
    command = input("명령어를 입력하세요: ")
    if command == "q" or command == "quit":
         break
    if command == "1" or command == "left" :
        t.left(90)
        t.forward(100)
    if command == "r" or command == "right" :
        t.right(90)
        t.forward(100)
    