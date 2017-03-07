from Tkinter import *
import timeit
import random
class Checkbar(Frame):
   def __init__(self, parent=None, picks=[], side=LEFT, anchor=W):
      Frame.__init__(self, parent)
      self.vars = []
      for pick in picks:
         var = IntVar()
         chk = Checkbutton(self, text=pick, variable=var)
         chk.pack(side=side, anchor=anchor, expand=YES)
         self.vars.append(var)


   def state(self):
      return map((lambda var: var.get()), self.vars)

if __name__ == '__main__':
   root = Tk()

   lng = Checkbar(root, ['Bubble', 'Merge', 'Quick'])
   tgl = Checkbar(root, ['Small','Medium', 'Large'])

   lng.pack(side=TOP,  fill=X)
   tgl.pack(side=TOP,  fill=X)

   lng.config(relief=GROOVE, bd=2)
   tgl.config(relief=GROOVE, bd=2)

   v = StringVar()
   Label(root, textvariable=v).pack()

   sort = ""


###############################################################################


smallList = [random.randint(0,100) for r in xrange(10000)]
mediumList = [random.randint(0,1000) for r in xrange(10000)]
largeList = [random.randint(0,10000) for r in xrange(10000)]


##########################bubble sort##########################################
def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp


#########################merge sort####################################
def mergeSort(alist):
    print("Splitting ",alist)
    if len(alist)>1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1


################quick sort############################
def quickSort(alist):
   quickSortHelper(alist,0,len(alist)-1)

def quickSortHelper(alist,first,last):
   if first<last:

       splitpoint = partition(alist,first,last)

       quickSortHelper(alist,first,splitpoint-1)
       quickSortHelper(alist,splitpoint+1,last)


def partition(alist,first,last):
   pivotvalue = alist[first]

   leftmark = first+1
   rightmark = last

   done = False
   while not done:

       while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
           leftmark = leftmark + 1

       while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
           rightmark = rightmark -1

       if rightmark < leftmark:
           done = True
       else:
           temp = alist[leftmark]
           alist[leftmark] = alist[rightmark]
           alist[rightmark] = temp

   temp = alist[first]
   alist[first] = alist[rightmark]
   alist[rightmark] = temp


   return rightmark

def sortItems():
    if tgl.state() == [1,0,0]:
        if sort == "Bubble":
            time = timeit.timeit(bubbleSort(smallList))
            print time
            smallList.sort()
        elif sort == "Merge":
            time = timeit.timeit(mergeSort(smallList))
            print time
            mergeSort(smallList)
            smallList.sort()
        elif sort == "Quick":
            time = timeit.timeit(quickSort(smallList))
            print time
            smallList.sort()

    elif tgl.state() == [0,1,0]:
        if sort == "Bubble":
            bubbleSort(mediumList)
            mediumList.sort()
        elif sort == "Merge":
            mergeSort(mediumList)
            mediumList.sort()
        elif sort == "Quick":
            quickSort(mediumList)
            mediumList.sort()

    elif tgl.state() == [0,0,1]:
        if sort == "Bubble":
            bubbleSort(largeList)
            largeList.sort()
        elif sort == "Merge":
            mergeSort(largeList)
            largeList.sort()
        elif sort == "Quick":
            quickSort(largeList)
            largeList.sort()
    else:
        v.set("Only choose one sort")





def allstates():
    if lng.state() == [1,0,0]:
        sort = "Bubble"
        v.set("Bubble")
    elif lng.state() == [0,1,0]:
        sort = "Merge"
        v.set("Merge")
    elif lng.state() == [0,0,1]:
        sort = "Quick"
        v.set("Quick")
    else:
        sort = ""
        v.set("Only choose one sort method")

    print sort

    print(list(lng.state()), list(tgl.state()))


Button(root, text='Sort', command=sortItems()).pack()
Button(root, text='Results', command=allstates()).pack()


root.mainloop()



