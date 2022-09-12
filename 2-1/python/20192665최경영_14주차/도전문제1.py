from PIL import Image, ImageTk, ImageFilter, ImageDraw
import tkinter as tk
from tkinter.colorchooser import askcolor
from tkinter import filedialog as fd

im = None
tk_img = None
mode = None
mycolor = None
old_x, old_y = None,  None


window = tk.Tk()
canvas = tk.Canvas(window, bg='white', width=840, height=680)


def open():    
    global im, tk_img    
    fname = fd.askopenfilename()
    im = Image.open(fname)    
    tk_img = ImageTk.PhotoImage(im)    
    canvas.config(width=im.width, height=im.height)    
    canvas.create_image(im.width/2, im.height/2, image=tk_img)    
    window.update() 

def quit():
    window.quit()

def image_rotate():    
    global im, tk_img  
    out = im.rotate(45)    
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def image_blur():    
    global im, tk_img    
    out = im.filter(ImageFilter.BLUR)    
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def image_black():
    global im, tk_img    
    out = im.convert('L')   
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def image_two():
    global im, tk_img    
    out = im.convert('1')
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def image_e():
    global im, tk_img    
    out = im.filter(ImageFilter.EMBOSS) 
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def image_dd():
    global im, tk_img    
    out = im.filter(ImageFilter.SHARPEN)
    tk_img = ImageTk.PhotoImage(out)    
    canvas.create_image(250, 250, image=tk_img)    
    window.update()

def saveImage():    
    global im, fname    
    fname = fd.asksaveasfilename(title="파일저장",        
    filetypes=(("png file", "*.png"),  ("gif file", "*.gif"),                                     
    ("jpg file", "*.jpg"), ("all files", "*.*")))
    im.save(fname)

def reset(event):   # 사용자가 마우스 버튼에서 손을 떼면 이전 점을 삭제한다.    
    global old_x, old_y
    old_x, old_y = None, None

def paint(event):   # 이전 점과 현재 점 사이를 직선으로 연결한다.
    global  im, mode, old_x, old_y
    fill_color = 'white' if mode == "erase" else mycolor
    if old_x and old_y:
        # canvas에 그리기
        canvas.create_line(old_x, old_y, event.x, event.y, width=mypenwidth, fill=fill_color)
         #  canvas에 연결된 이미지 객체에 같은 내용을 그리기
        draw = ImageDraw.Draw(im)
        draw.line((old_x, old_y, event.x, event.y), fill=fill_color, width = mypenwidth)
    old_x = event.x
    old_y = event.y

def choose_color(): # 색상 메뉴가 선택되면 사용자한테 색상을 요구한다.
    global mycolor
    mycolor = askcolor(color=mycolor)[1]  
    # [1]은 :  #00ff00 형식이고  |  [0]는 ->  (0, 255, 0)  형식이다.

def change_width(my_width):
    global mypenwidth
    mypenwidth = my_width

def initialize_image():
    global im, tk_img
    im =  Image.new('RGB', (840, 680), color=(256,256,256))
    tk_img = ImageTk.PhotoImage(im)
    canvas.config(width=im.width, height=im.height)
    canvas.create_image(im.width/2, im.height/2, image=tk_img)
    window.update()    

# 프로그램 첫 실행 시에 canvas 크기와 같은 전역 im 이미지 객체 생성



menubar = tk.Menu(window)
filemenu = tk.Menu(menubar)
ipmenu = tk.Menu(menubar)
wmenu = tk.Menu(menubar)
filemenu.add_command(label="열기", command=open)
filemenu.add_command(label="저장", command=saveImage)
filemenu.add_separator()
filemenu.add_command(label="종료", command=quit)
ipmenu.add_command(label="영상회전", command=image_rotate)
ipmenu.add_command(label="영상흐리게", command=image_blur)
ipmenu.add_command(label="흑백영상", command=image_black)
ipmenu.add_command(label="이진화", command=image_two)
ipmenu.add_command(label="영상뚜렷하게", command=image_dd)
ipmenu.add_command(label="엠보스", command=image_e)
wmenu.add_command(label="Line Color", command=choose_color)
wmenu.add_separator()
wmenu.add_command(label="넓이 2", command=change_width(2))
wmenu.add_command(label="넓이 5", command=change_width(5))
wmenu.add_command(label="넓이 8", command=change_width(8))
menubar.add_cascade(label="파일", menu=filemenu)
menubar.add_cascade(label="영상처리", menu=ipmenu)
menubar.add_cascade(label="선색 두께", menu=wmenu)

canvas.bind("<B1-Motion>", paint)
canvas.bind('<ButtonRelease-1>', reset)
canvas.pack()
initialize_image()
window.config(menu=menubar)
window.mainloop()