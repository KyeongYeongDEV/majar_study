import turtle
import random

t1 =turtle.Turtle()
t2 =turtle.Turtle()

num=1
player1 = -100
player2 = -100

def run():
    global num
    global player1
    global player2

    if num %2 == 1:
        randnum = random.randint(1,30)
        t1.forward(randnum)
        num  = num+1
        player1 = player1 + randnum
        
    else:
        randnum = random.randint(1,30)
        t2.forward(randnum)
        num  = num+1    
        player2 = player2 + randnum

def out():
    global player1
    global player2

    if player1 >= 200 :
        t1.write("              player1 Win!!")
        return True
        
    elif player2 >= 200 :
        t2.write("              player2 Win!!")
        return True
        

t1.shape("turtle")
t1.pensize(5)

t1.color("black")
t1.left(90)
t1.up()
t1.goto(200,-200)
t1.down()
t1.forward(500)
t1.right(90)

t1.color("pink")
t1.up()
t1.goto(-100,-50)
t1.down()
t2.shape("turtle")
t2.color("blue")
t2.pensize(5)
t2.up()
t2.goto(-100,0)
t2.down()

while True:
    run()
    if out():
        break

    
  

turtle.mainloop()