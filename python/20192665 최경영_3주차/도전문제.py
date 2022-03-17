import turtle
t = turtle.Turtle()
t.shape("turtle")


size = int(input("집의 크기는 얼마로 할까요? "))


t.penup()
t.goto(-(size/2), 0)
t.pendown()
# size=100
# 사각형을 그린다. 
t.forward(size)	# size 만큼 거북이를 전진시킨다. 
t.right(90)		# 거북이를 오른쪽으로 90도 회전시킨다. 
t.forward(size)
t.right(90)
t.forward(size)
t.right(90)
t.forward(size)



# 이제 지붕을 그릴 차례이다.
t.right(90)

# 지붕을 그리면 된다.
t.forward(size)
t.left(120)
t.forward(size)
t.left(120)
t.forward(size)
t.left(120)

#왼지붕 아래
t.right(120)
t.forward(size/3)

#오른 지붕 아래
t.left(180)
t.forward(size/3)
t.right(60)
t.forward(size)
t.right(60)
t.forward(size/3)

#창문
t.up()
t.goto(-size/5,-size/5)
t.down()
t.right(30)

t.forward(size/3)
t.left(90)
t.forward(size/3)
t.left(90)
t.forward(size/3)
t.left(90)
t.forward(size/3)
t.left(90)


turtle.done()