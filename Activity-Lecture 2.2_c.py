#input five marks of a student and display the grades.
marks = [] 

for i in range(5): 
    mark = int(input("Enter the marks of the student: ")) 
    marks.append(mark) 

for mark in marks: 
    if mark > 75: 
        print("Grade: A") 
    elif mark >= 65 and mark <= 75: 
        print("Grade: B") 
    elif mark >= 55 and mark <= 64: 
        print("Grade: C") 
    elif mark >= 45 and mark <= 54: 
        print("Grade: S") 
    else: 
        print("Grade: F")