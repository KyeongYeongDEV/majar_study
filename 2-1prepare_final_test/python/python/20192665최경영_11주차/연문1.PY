from tkinter import * # tkinter 모듈을 포함

window = Tk()

program = Label(window, text = "간단한 GUI 프로그램!")
program.pack()

wel_button = Button(window, text = "환영합니다.")
close_button = Button(window,text = "종료")

wel_button.pack()
close_button.pack()

window.mainloop()