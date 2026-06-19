# Define function to calculate sum
def calculateSum(num):
    if num:
        # Recursive function call
        return num + calculateSum(num-1)
    else:
        return 0

# call the calculateSum function
res = calculateSum(10)

# print result
print(res)